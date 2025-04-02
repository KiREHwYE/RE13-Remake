package com.kire.home.data.mapper.to_domain

import com.kire.database.model.TrackWithAlbumAndArtist

/**
 * Converts a list of [TrackWithAlbumAndArtist] objects from the data layer into a list of [TrackDomain] objects for the domain layer.
 * This extension function applies the [TrackWithAlbumAndArtist.toDomain] mapping to each element in the list,
 * providing a convenient way to transform an entire collection of database entities into platform-independent
 * domain models for use in business logic.
 *
 * @receiver The list of [TrackWithAlbumAndArtist] instances to be converted.
 * @return A list of [TrackDomain] instances, each mapped from a corresponding [TrackWithAlbumAndArtist] in this list.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun List<TrackWithAlbumAndArtist>.toDomain() = this.map { TrackWithAlbumAndArtist ->
    TrackWithAlbumAndArtist.toDomain()
}