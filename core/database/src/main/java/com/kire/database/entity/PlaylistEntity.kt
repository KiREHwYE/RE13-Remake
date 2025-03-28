package com.kire.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents information about playlist created by user
 *
 * @param id Unique identifier of the playlist. Defaults to 0 if not specified.
 * @param title Title of the playlist
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey
    val id: Long = 0,
    val title: String
)
