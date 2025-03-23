package com.kire.database.entity

import androidx.room.Entity

/**
 * Represents the relationship between playlist and tracks
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(primaryKeys = ["playlistId", "trackId"])
data class PlaylistTrackCrossRef(
    val playlistId: Long,
    val trackId: Long
)
