package com.kire.home.domain.repository

import com.kire.home.domain.model.TrackDomain
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing track-related data.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
interface ITrackRepository {

    /**
     * Inserts or updates a track entity in the database.
     * If the track already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param track The [TrackDomain] to upsert.
     */
    suspend fun upsertTrack(track: TrackDomain)

    /**
     * Deletes a track entity from the database.
     *
     * @param track The [TrackDomain] to delete.
     */
    suspend fun deleteTrack(track: TrackDomain)

    /**
     * Retrieves a track entity by its unique identifier.
     *
     * @param id The unique identifier of the track.
     * @return The [TrackDomain] with the specified [id], or null if no such track exists.
     */
    suspend fun getTrackById(id: Int): TrackDomain

    /**
     * Retrieves all track entities from the database as a Flow.
     *
     * @return A [Flow] emitting a list of all [TrackDomain] objects in the database.
     */
    suspend fun getAllTracks(): Flow<List<TrackDomain>>

    /**
     * Refreshes the database with tracks retrieved from external storage.
     */
    suspend fun refreshTracks()
}