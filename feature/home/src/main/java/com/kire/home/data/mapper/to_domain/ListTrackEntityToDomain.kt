package com.kire.home.data.mapper.to_domain

import com.kire.database.model.entity.TrackEntity

/**
 * Converts a list of [TrackEntity] objects from the data layer into a list of [TrackDomain] objects for the domain layer.
 * This extension function applies the [TrackEntity.toDomain] mapping to each element in the list,
 * providing a convenient way to transform an entire collection of database entities into platform-independent
 * domain models for use in business logic.
 *
 * @receiver The list of [TrackEntity] instances to be converted.
 * @return A list of [TrackDomain] instances, each mapped from a corresponding [TrackEntity] in this list.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun List<TrackEntity>.toDomain() = this.map { trackEntity ->
    trackEntity.toDomain()
}