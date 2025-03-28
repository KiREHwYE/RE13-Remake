package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents information about playlist created by user
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey
    val id: Long = 0,
    val title: String
)
