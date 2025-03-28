package com.kire.database.entity

import androidx.room.Entity

/**
 * Represents the relationship between playlist and tracks
 *
 * @param playlistId Unique identifier of the playlist.
 * @param trackId Unique identifier of the track associated with playlist.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(primaryKeys = ["playlistId", "trackId"])
data class PlaylistTrackCrossRef(
    val playlistId: Long,
    val trackId: Long
)
