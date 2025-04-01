package com.kire.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kire.database.model.entity.PlaylistEntity
import com.kire.database.model.entity.PlaylistTrackCrossRef
import com.kire.database.model.entity.TrackEntity

/**
 * Represents a playlist with its associated tracks, retrieved from the database.
 * Combines [PlaylistEntity] with a list of [TrackEntity] instances linked via [PlaylistTrackCrossRef].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class PlaylistWithTracks(
    @Embedded
    val playlist: PlaylistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PlaylistTrackCrossRef::class,
            parentColumn = "playlistId",
            entityColumn = "trackId"
        )
    )
    val tracks: List<TrackEntity>
)