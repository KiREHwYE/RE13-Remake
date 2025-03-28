package com.kire.database.audio_reader

import android.provider.MediaStore

/**
 * Represents an audio file with its metadata, used as an intermediate structure before splitting into
 * database entities like [TrackEntity], [AlbumEntity], and [ArtistEntity].
 * This data class encapsulates all relevant information about an audio file sourced from MediaStore,
 * intended for subsequent decomposition and storage in the application's local database.
 *
 * @param id Unique identifier of the audio file, sourced from [MediaStore.Audio.Media._ID]. Defaults to 0 if not specified.
 * @param artistId Identifier of the artist, linking to [MediaStore.Audio.Artists._ID]. Nullable and defaults to 0 if unknown.
 * @param albumId Identifier of the album, linking to [MediaStore.Audio.Albums._ID]. Nullable and defaults to 0 if unknown.
 * @param album Name of the album, sourced from [MediaStore.Audio.Media.ALBUM], to be stored as [AlbumEntity.title].
 * @param artist Name of the artist, sourced from [MediaStore.Audio.Media.ARTIST], to be stored as [ArtistEntity.name].
 * @param title Title of the audio file, sourced from [MediaStore.Audio.Media.TITLE], stored as [TrackEntity.title].
 * @param lyrics Lyrics of the audio file, nullable and defaults to null as not sourced from MediaStore directly.
 * @param duration Duration in milliseconds, sourced from [MediaStore.Audio.Media.DURATION], stored in [TrackEntity].
 * @param dateModified Last modification timestamp in seconds since epoch, sourced from [MediaStore.Audio.Media.DATE_MODIFIED].
 * @param bitrate Bitrate in bits per second, sourced from [MediaStore.Audio.Media.BITRATE], stored in [TrackEntity].
 * @param size Size in bytes, sourced from [MediaStore.Audio.Media.SIZE], stored in [TrackEntity].
 * @param data URI in String format to the audio file's location, constructed from [MediaStore.Audio.Media.DATA], stored as [TrackEntity.data].
 * @param artworkUri URI in String format to the album artwork, constructed using [MediaStore.Audio.Albums.ALBUM_ART] and [albumId].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class AudioFile(
    val id: Long = 0,
    val artistId: Long? = 0,
    val albumId: Long? = 0,
    val album: String,
    val artist: String,
    val title: String,
    val lyrics: String? = null,
    val duration: Long,
    val dateModified: Long,
    val bitrate: Long,
    val size: Long,
    val data: String,
    val artworkUri: String,
)