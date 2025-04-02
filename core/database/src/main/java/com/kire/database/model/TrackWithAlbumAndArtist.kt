package com.kire.database.model

import androidx.room.Embedded
import androidx.room.Relation
import com.kire.database.model.entity.AlbumEntity
import com.kire.database.model.entity.ArtistEntity
import com.kire.database.model.entity.TrackEntity

/**
 * Represents a track with its associated album and artist details retrieved from the database.
 * This entity combines data from [TrackEntity], [AlbumEntity], and [ArtistEntity].
 *
 * @param track The [TrackEntity] instance.
 * @param album The [AlbumEntity] instance.
 * @param artist The [ArtistEntity] instance.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
data class TrackWithAlbumAndArtist(
    @Embedded val track: TrackEntity,
    @Relation(
        parentColumn = "albumId",
        entityColumn = "id"
    )
    val album: AlbumEntity,
    @Relation(
        parentColumn = "artistId",
        entityColumn = "id"
    )
    val artist: ArtistEntity
)
