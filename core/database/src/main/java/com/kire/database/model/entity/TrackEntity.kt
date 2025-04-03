package com.kire.database.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Represents song information, including fields for title, artist, album, etc.
 *
 * @param id Unique identifier of the audio file. Defaults to 0 if not specified.
 * @param artistId Identifier of the artist. Nullable and defaults to null if unknown.
 * @param albumId Identifier of the album. Nullable and defaults to null if unknown.
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
@Entity(
    tableName = "tracks",
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = ["id"],
            childColumns = ["artistId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = ["id"],
            childColumns = ["albumId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class TrackEntity(
    @PrimaryKey
    val id: Long = 0,
    val artistId: Long? = null,
    val albumId: Long? = null,
    val title: String,
    val lyrics: String? = null,
    val duration: Long,
    val dateModified: Long,
    val bitrate: Long,
    val size: Long,
    val data: String,
    val artworkUri: String,
)