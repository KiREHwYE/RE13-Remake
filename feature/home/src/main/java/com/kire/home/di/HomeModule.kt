package com.kire.home.di

import com.kire.database.dao.TrackDao
import com.kire.di.IODispatcher
import com.kire.home.data.TrackRepository
import com.kire.home.domain.repository.ITrackRepository
import com.kire.home.domain.usecase.GetAllTracksUseCase
import com.kire.home.domain.usecase.ITrackUseCases
import com.kire.home.domain.usecase.TrackUseCases
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Dagger module providing dependencies for the home feature, including track-related use cases and repositories.
 * This module defines how to instantiate and provide implementations of [ITrackRepository], [ITrackUseCases],
 * and [GetAllTracksUseCase].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Module
object HomeModule {

    /**
     * Provides an [ITrackRepository] implementation for track data management.
     * Creates a [TrackRepository] instance using the injected [TrackDao] and an I/O-optimized
     * [CoroutineDispatcher], enabling database operations for tracks.
     *
     * @param trackDao The [TrackDao] instance for database access.
     * @param coroutineDispatcher The [CoroutineDispatcher] annotated with [@IODispatcher] for I/O-bound tasks.
     * @return An [ITrackRepository] instance, specifically a [TrackRepository].
     */
    @Provides
    fun provideTrackRepository(
        trackDao: TrackDao,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): ITrackRepository {
        return TrackRepository(trackDao, coroutineDispatcher)
    }

    /**
     * Provides an [ITrackUseCases] implementation for track-related use cases.
     * Creates a [TrackUseCases] instance using the injected [GetAllTracksUseCase], grouping
     * track use cases into a single injectable object for the domain layer.
     *
     * @param getAllTracksUseCase The [GetAllTracksUseCase] instance for retrieving all tracks.
     * @return An [ITrackUseCases] instance, specifically a [TrackUseCases].
     */
    @Provides
    fun provideTrackUseCases(getAllTracksUseCase: GetAllTracksUseCase): ITrackUseCases {
        return TrackUseCases(getAllTracksUseCase)
    }

    /**
     * Provides a [GetAllTracksUseCase] instance for retrieving all tracks.
     * Creates a [GetAllTracksUseCase] using the injected [ITrackRepository], enabling the use case
     * to fetch tracks from the database as a [Flow] of [TrackDomain] objects.
     *
     * @param trackRepository The [ITrackRepository] instance for accessing track data.
     * @return A [GetAllTracksUseCase] instance.
     */
    @Provides
    fun provideGetAllTracksUseCase(trackRepository: ITrackRepository): GetAllTracksUseCase {
        return GetAllTracksUseCase(trackRepository)
    }
}