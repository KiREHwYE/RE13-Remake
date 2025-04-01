package com.kire.home.data.mapper.to_domain

import com.kire.database.model.entity.TrackEntity
import com.kire.home.domain.model.TrackDomain

/**
 * Converts a [TrackEntity] from the data layer into a [TrackDomain] for the domain layer.
 * This extension function maps all fields of the [TrackEntity] to a new [TrackDomain] instance,
 * ensuring a seamless transition between the database representation and the platform-independent
 * domain model used for business logic
 *
 * @receiver The [TrackEntity] instance to be converted.
 * @return A [TrackDomain] instance with fields mapped from this [TrackEntity].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun TrackEntity.toDomain() = TrackDomain(
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