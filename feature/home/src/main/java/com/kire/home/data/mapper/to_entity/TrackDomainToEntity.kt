package com.kire.home.data.mapper.to_entity

import com.kire.database.model.entity.TrackEntity
import com.kire.home.domain.model.TrackDomain

/**
 * Converts a [TrackDomain] from the domain layer into a [TrackEntity] for the data layer.
 * This extension function maps all fields of the [TrackDomain] to a new [TrackEntity] instance,
 * ensuring a seamless transition between the database representation and the platform-independent
 * domain model used for business logic
 *
 * @receiver The [TrackDomain] instance to be converted.
 * @return A [TrackEntity] instance with fields mapped from this [TrackDomain].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun TrackDomain.toEntity() = TrackEntity(
    id = this.id,
    artistId = this.artistId,
    albumId = this.albumId,
    title = this.title,
    lyrics = this.lyrics,
    duration = this.duration,
    dateModified = this.dateModified,
    bitrate = this.bitrate,
    size = this.size,
    data = this.data,
    artworkUri = this.artworkUri
)