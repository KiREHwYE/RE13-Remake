package com.kire.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.kire.database.entity.PlaylistEntity
import com.kire.database.entity.PlaylistTrackCrossRef
import com.kire.database.entity.TrackEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing playlist-related data in the database.
 * Provides methods for creating, updating, and querying playlists and their associated tracks.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Dao
interface PlaylistDao {

    /**
     * Inserts or updates a playlist entity in the database.
     * If the playlist already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param playlist The [PlaylistEntity] to upsert.
     */
    @Upsert
    suspend fun upsertPlaylist(playlist: PlaylistEntity)

    /**
     * Retrieves all playlist entities from the database as a Flow.
     *
     * @return A [Flow] emitting a list of all [PlaylistEntity] objects in the database.
     */
    @Query("SELECT * FROM playlists")
    fun getAllPlaylists(): Flow<List<PlaylistEntity>>

    /**
     * Adds a track to a playlist by inserting a cross-reference entity.
     *
     * @param ref The [PlaylistTrackCrossRef] representing the relationship between a playlist and tracks.
     */
    @Upsert
    suspend fun addTrackToPlaylist(ref: PlaylistTrackCrossRef)

    /**
     * Removes a track from a playlist.
     *
     * @param ref The [PlaylistTrackCrossRef] representing the relationship to remove.
     */
    @Delete
    suspend fun deleteTrackFromPlaylist(ref: PlaylistTrackCrossRef)

    /**
     * Retrieves all tracks associated with a specific playlist as a Flow.
     * Joins the tracks table with the cross-reference table to filter tracks by playlist ID.
     *
     * @param playlistId The unique identifier of the playlist.
     * @return A [Flow] emitting a list of [TrackEntity] objects associated with the specified [playlistId].
     */
    @Query("""
        SELECT * FROM tracks 
        INNER JOIN PlaylistTrackCrossRef ON tracks.id = PlaylistTrackCrossRef.trackId
        WHERE PlaylistTrackCrossRef.playlistId = :playlistId
    """)
    fun getTracksByPlaylist(playlistId: Long): Flow<List<TrackEntity>>
}
