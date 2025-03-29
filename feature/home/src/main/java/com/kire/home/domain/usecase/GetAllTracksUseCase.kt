package com.kire.home.domain.usecase

import com.kire.home.domain.repository.ITrackRepository
import javax.inject.Inject

/**
 * Use case for retrieving all tracks from the database.
 * This class encapsulates the logic for fetching all available tracks as a [Flow] of list filled with [TrackDomain] objects,
 * delegating the data retrieval to the provided [ITrackRepository].
 *
 * @param trackRepository The [ITrackRepository] instance used to access track data, injected via Dagger.
 */
class GetAllTracksUseCase @Inject constructor(
    private val trackRepository: ITrackRepository
) {
    /**
     * Retrieves all tracks from the database as a Flow.
     * This operator function invokes the underlying [ITrackRepository.getAllTracks] method,
     * returning a [Flow] that emits a list of [TrackDomain] objects representing all tracks stored in the database.
     *
     * @return A [Flow] emitting a list of [TrackDomain] objects.
     */
     operator fun invoke() =
        trackRepository.getAllTracks()
}