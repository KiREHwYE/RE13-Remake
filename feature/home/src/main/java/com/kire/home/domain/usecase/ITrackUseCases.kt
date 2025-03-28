package com.kire.home.domain.usecase

/**
 * Sealed interface defining a collection of use cases related to track management.
 * This interface groups together various use case implementations for operations on [TrackDomain] entities,
 * ensuring a structured and type-safe way to access track-related business logic within the domain layer.
 *
 * @property getAllTracksUseCase The [GetAllTracksUseCase] instance responsible for retrieving all tracks
 *                               from the database as a [Flow] of [TrackDomain] objects.
 */
sealed interface ITrackUseCases {
    val getAllTracksUseCase: GetAllTracksUseCase
}