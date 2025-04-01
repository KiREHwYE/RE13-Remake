package com.kire.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.kire.database.model.entity.PlaylistEntity
import com.kire.database.model.entity.PlaylistTrackCrossRef
import com.kire.database.model.PlaylistWithTracks
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrackToPlaylist(ref: PlaylistTrackCrossRef)

    /**
     * Removes a track from a playlist.
     *
     * @param ref The [PlaylistTrackCrossRef] representing the relationship to remove.
     */
    @Delete
    suspend fun deleteTrackFromPlaylist(ref: PlaylistTrackCrossRef)

    /**
     * Retrieves a playlist and its associated tracks by playlist ID.
     *
     * @param playlistId The unique identifier of the playlist.
     * @return A [Flow] emitting a [PlaylistWithTracks].
     */
    @Transaction
    @Query("SELECT * FROM playlists WHERE id = :playlistId")
    fun getPlaylistWithTracks(playlistId: Long): Flow<PlaylistWithTracks>
}
