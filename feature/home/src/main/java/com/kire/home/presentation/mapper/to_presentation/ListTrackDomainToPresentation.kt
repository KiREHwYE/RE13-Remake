package com.kire.home.presentation.mapper.to_presentation

import com.kire.home.domain.model.TrackDomain

/**
 * Converts a list of [TrackDomain] objects from the data layer into a list of [Track] objects for the presentation layer.
 * This extension function applies the [TrackDomain.toPresentation] mapping to each element in the list.
 *
 * @receiver The list of [TrackDomain] instances to be converted.
 * @return A list of [Track] instances, each mapped from a corresponding [TrackDomain] in this list.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun List<TrackDomain>.toPresentation() = this.map { trackDomain ->
    trackDomain.toPresentation()
}