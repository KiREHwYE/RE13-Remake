package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents album information, including fields for title, artist and artwork uri.
 *
 * @param id Unique identifier of album. Defaults to 0 if not specified.
 * @param artistId Identifier of the artist. Nullable and defaults to 0 if unknown.
 * @param title Title of the audio file.
 * @param artworkUri URI in String format to the album artwork.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey
    val id: Long = 0,
    val title: String,
    val artistId: Long?,
    val artworkUri: String?
)
