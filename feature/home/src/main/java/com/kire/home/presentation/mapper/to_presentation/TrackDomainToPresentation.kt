package com.kire.home.presentation.mapper.to_presentation

import com.kire.home.domain.model.TrackDomain
import com.kire.home.presentation.model.Track

/**
 * Converts a [TrackDomain] from the domain layer into a [Track] for the presentation layer.
 * This extension function maps all fields of the [TrackDomain] to a new [Track] instance.
 *
 * @receiver The [TrackDomain] instance to be converted.
 * @return A [Track] instance with fields mapped from this [TrackDomain].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun TrackDomain.toPresentation() = Track(
    id = this.id,
    artistName = this.artistName,
    albumTitle = this.albumTitle,
    title = this.title,
    lyrics = this.lyrics,
    duration = this.duration,
    dateModified = this.dateModified,
    bitrate = this.bitrate,
    size = this.size,
    data = this.data,
    artworkUri = this.artworkUri
)