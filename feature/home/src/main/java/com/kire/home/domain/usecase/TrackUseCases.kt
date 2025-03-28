package com.kire.home.domain.usecase

import javax.inject.Inject

/**
 * Data class implementing [ITrackUseCases] to provide track-related use cases.
 * This class serves as a concrete implementation of the [ITrackUseCases] sealed interface, encapsulating
 * a collection of use cases for managing [TrackDomain] entities.
 *
 * @param getAllTracksUseCase The [GetAllTracksUseCase] instance responsible for retrieving all tracks
 *                            from the database as a [Flow] of [TrackDomain] objects, injected via Dagger.
 */
data class TrackUseCases @Inject constructor(
    override val getAllTracksUseCase: GetAllTracksUseCase
): ITrackUseCases