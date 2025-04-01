package com.kire.database.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Represents the relationship between playlist and tracks
 *
 * @param playlistId Unique identifier of the playlist.
 * @param trackId Unique identifier of the track associated with playlist.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Entity(
    tableName = "playlist_track_cross_ref",
    primaryKeys = ["playlistId", "trackId"],
    foreignKeys = [
        ForeignKey(
            entity = PlaylistEntity::class,
            parentColumns = ["id"],
            childColumns = ["playlistId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TrackEntity::class,
            parentColumns = ["id"],
            childColumns = ["trackId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["playlistId"])
    ]
)
data class PlaylistTrackCrossRef(
    val playlistId: Long,
    val trackId: Long
)
