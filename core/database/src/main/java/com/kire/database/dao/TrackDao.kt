package com.kire.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.kire.database.model.entity.TrackEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing track-related data in the database.
 * Provides methods for upserting, deleting, etc.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Dao
interface TrackDao {

    /**
     * Inserts or updates a track entity in the database.
     * If the track already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param track The [TrackEntity] to upsert.
     */
    @Upsert
    suspend fun upsertTrack(track: TrackEntity)

    /**
     * Deletes a track entity from the database.
     *
     * @param track The [TrackEntity] to delete.
     */
    @Delete
    suspend fun deleteTrack(track: TrackEntity)

    /**
     * Retrieves a track entity by its unique identifier.
     *
     * @param id The unique identifier of the track.
     * @return The [TrackEntity] with the specified [id], or null if no such track exists.
     */
    @Query("SELECT * FROM tracks WHERE id = :id")
    suspend fun getTrackById(id: Long): TrackEntity?

    /**
     * Retrieves all track entities from the database as a Flow.
     *
     * @return A [Flow] emitting a list of all [TrackEntity] objects in the database.
     */
    @Query("SELECT * FROM tracks")
    fun getAllTracks(): Flow<List<TrackEntity>>
}