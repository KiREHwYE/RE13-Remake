package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents album information, including fields for title, artist and artwork uri.
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
