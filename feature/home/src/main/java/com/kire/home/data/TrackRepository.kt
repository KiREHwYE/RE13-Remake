package com.kire.home.data

import com.kire.database.dao.TrackDao
import com.kire.di.IODispatcher
import com.kire.home.data.mapper.to_domain.toDomain
import com.kire.home.data.mapper.to_entity.toEntity
import com.kire.home.domain.model.TrackDomain
import com.kire.home.domain.repository.ITrackRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Repository implementation for managing track-related data in the database.
 * This class implements [ITrackRepository] to provide concrete functionality for upserting, deleting,
 * and retrieving tracks, using [TrackDao] for database operations.
 * Utilizes [CoroutineDispatcher] to ensure I/O-bound tasks are performed off the main thread.
 *
 * @param trackDao The [TrackDao] instance for interacting with the track database table, injected via Dagger.
 * @param coroutineDispatcher The [CoroutineDispatcher] for executing database operations, annotated with
 *                            [@IODispatcher] to specify an I/O-optimized thread pool, injected via Dagger.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
class TrackRepository @Inject constructor(
    private val trackDao: TrackDao,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) : ITrackRepository {

    /**
     * Inserts or updates a track entity in the database.
     * This suspend function converts the provided [TrackDomain] to a [TrackEntity] using [TrackDomain.toEntity]
     * and delegates the upsert operation to [TrackDao.upsertTrack].
     *
     * @param track The [TrackDomain] to upsert.
     */
    override suspend fun upsertTrack(track: TrackDomain) {
        return withContext(coroutineDispatcher) {
            trackDao.upsertTrack(track.toEntity())
        }
    }

    /**
     * Deletes a track entity from the database.
     * This suspend function converts the provided [TrackDomain] to a [TrackEntity] using [TrackDomain.toEntity]
     * and delegates the deletion to [TrackDao.deleteTrack].
     *
     * @param track The [TrackDomain] to delete.
     */
    override suspend fun deleteTrack(track: TrackDomain) {
        return withContext(coroutineDispatcher) {
            trackDao.deleteTrack(track.toEntity())
        }
    }

    /**
     * Retrieves all track entities from the database as a [Flow].
     * This function fetches a [Flow] of [TrackEntity] lists from [TrackDao.getAllTracksWithAlbumAndArtist],
     * maps each list to a list of [TrackDomain] objects using [List<TrackEntity>.toDomain], and returns
     * the resulting [Flow].
     *
     * @return A list of all [TrackDomain] objects in the database.
     */
    override fun getAllTracks(): Flow<List<TrackDomain>> {
        return trackDao.getAllTracksWithAlbumAndArtist().map {
            it.toDomain()
        }
    }
}