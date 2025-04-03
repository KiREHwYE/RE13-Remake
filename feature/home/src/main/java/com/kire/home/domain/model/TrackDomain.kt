package com.kire.home.domain.model

/**
 * Represents song information, including fields for title, artist, album, etc.
 *
 * @param id Unique identifier of the audio file.
 * @param artistId Identifier of the artist.
 * @param albumId Identifier of the album.
 * @param artistName What artist calls himself.
 * @param albumTitle Title of the album this song related to.
 * @param title Title of the audio file.
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
data class TrackDomain(
    val id: Long,
    val artistId: Long,
    val albumId: Long,
    val artistName: String,
    val albumTitle: String,
    val title: String,
    val lyrics: String? = null,
    val duration: Long,
    val dateModified: Long,
    val bitrate: Long,
    val size: Long,
    val data: String,
    val artworkUri: String,
)