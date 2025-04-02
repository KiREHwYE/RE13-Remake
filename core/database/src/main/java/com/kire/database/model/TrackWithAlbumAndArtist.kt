package com.kire.database.model

import com.kire.database.model.entity.AlbumEntity
import com.kire.database.model.entity.ArtistEntity
import com.kire.database.model.entity.TrackEntity

/**
 * Represents a track with its associated album and artist details retrieved from the database.
 * This entity combines data from [TrackEntity], [AlbumEntity], and [ArtistEntity].
 *
 * @param id Unique identifier of the audio file. Defaults to 0 if not specified.
 * @param title Title of the audio file.
 * @param albumTitle Title of the album.
 * @param artistName What the artist calls himself.
 * @param lyrics Lyrics of the audio file, nullable and defaults to null.
 * @param duration Duration in milliseconds.
 * @param dateModified Last modification timestamp in seconds since epoch.
 * @param bitrate Bitrate in bits per second.
 * @param size Size in bytes.
 * @param data URI in String format to the audio file's location.
 * @param artworkUri URI in String format to the album artwork.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class TrackWithAlbumAndArtist(
    val id: Long,
    val title: String,
    val albumTitle: String,
    val artistName: String,
    val duration: Long,
    val lyrics: String? = null,
    val dateModified: Long,
    val bitrate: Long,
    val size: Long,
    val data: String,
    val artworkUri: String,
)
