package com.kire.data

import com.kire.data.audio_reader.AudioReader
import com.kire.database.dao.AlbumDao
import com.kire.database.dao.ArtistDao
import com.kire.database.dao.TrackDao
import com.kire.database.model.entity.AlbumEntity
import com.kire.database.model.entity.ArtistEntity
import com.kire.database.model.entity.TrackEntity
import com.kire.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Updates the local Room database with audio file metadata retrieved from the device's MediaStore.
 * This class synchronizes [TrackEntity], [ArtistEntity], and [AlbumEntity] based on data from [AudioReader].
 *
 * @param audioReader The [AudioReader] instance to fetch audio file metadata.
 * @param trackDao The [TrackDao] for managing track entities.
 * @param artistDao The [ArtistDao] for managing artist entities.
 * @param albumDao The [AlbumDao] for managing album entities.
 * @param coroutineDispatcher The [CoroutineDispatcher] annotated with [@IODispatcher] for I/O-bound tasks.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
class DatabaseUpdater @Inject constructor(
    private val audioReader: AudioReader,
    private val trackDao: TrackDao,
    private val artistDao: ArtistDao,
    private val albumDao: AlbumDao,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    /**
     * Synchronizes the local database with audio files from the device's MediaStore.
     * Retrieves audio files using [AudioReader], maps them to [TrackEntity], [ArtistEntity], and [AlbumEntity],
     * and upserts them into the database.
     */
    suspend fun updateDatabase() {
        val audioFiles = audioReader.getAllAudioFiles()

        val artists = audioFiles
            .mapNotNull { audioFile ->
                audioFile.artistId?.let { artistId ->
                    ArtistEntity(
                        id = artistId,
                        name = audioFile.artist
                    )
                }
            }
            .distinctBy { it.id }

        val albums = audioFiles
            .mapNotNull { audioFile ->
                audioFile.albumId?.let { albumId ->
                    AlbumEntity(
                        id = albumId,
                        title = audioFile.album,
                        artistId = audioFile.artistId,
                        artworkUri = audioFile.artworkUri
                    )
                }
            }
            .distinctBy { it.id }

        val tracks = audioFiles.map { audioFile ->
            TrackEntity(
                id = audioFile.id,
                artistId = audioFile.artistId,
                albumId = audioFile.albumId,
                title = audioFile.title,
                lyrics = audioFile.lyrics,
                duration = audioFile.duration,
                dateModified = audioFile.dateModified,
                bitrate = audioFile.bitrate,
                size = audioFile.size,
                data = audioFile.data,
                artworkUri = audioFile.artworkUri
            )
        }

        withContext(coroutineDispatcher) {
            artistDao.upsertArtists(artists)
            albumDao.upsertAlbums(albums)
            trackDao.upsertTracks(tracks)
        }
    }
}