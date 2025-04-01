package com.kire.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.kire.database.entity.AlbumEntity
import com.kire.database.entity.TrackEntity

/**
 * Represents an album with its associated tracks, retrieved from the database.
 * Combines [AlbumEntity] with a list of [TrackEntity] instances linked via [albumId].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class AlbumWithTracks(
    @Embedded
    val album: AlbumEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "albumId"
    )
    val tracks: List<TrackEntity>
)