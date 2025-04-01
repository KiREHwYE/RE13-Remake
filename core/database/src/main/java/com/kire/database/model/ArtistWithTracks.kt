package com.kire.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.kire.database.entity.ArtistEntity
import com.kire.database.entity.TrackEntity

/**
 * Represents an artist with its associated tracks, retrieved from the database.
 * Combines [ArtistEntity] with a list of [TrackEntity] instances linked via [artistId].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class ArtistWithTracks(
    @Embedded
    val artist: ArtistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "artistId"
    )
    val tracks: List<TrackEntity>
)