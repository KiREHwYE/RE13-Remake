package com.kire.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.kire.database.model.entity.AlbumEntity
import com.kire.database.model.AlbumWithTracks
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing album-related data in the database.
 * Provides methods for upserting, deleting and querying album entities.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Dao
interface AlbumDao {

    /**
     * Inserts or updates an album entity in the database.
     * If the album already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param album The [AlbumEntity] to upsert.
     */
    @Upsert
    suspend fun upsertAlbum(album: AlbumEntity)

    /**
     * Deletes an album entity from the database.
     *
     * @param album The [AlbumEntity] to delete.
     */
    @Delete
    suspend fun deleteAlbum(album: AlbumEntity)

    /**
     * Retrieves all album entities from the database as a Flow.
     *
     * @return A [Flow] emitting a list of all [AlbumEntity] objects in the database.
     */
    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Flow<List<AlbumEntity>>

    /**
     * Retrieves an album entity by its unique identifier.
     *
     * @param albumId The unique identifier of the album.
     * @return The [AlbumEntity] with the specified [albumId], or null if no such album exists.
     */
    @Query("SELECT * FROM albums WHERE id = :albumId")
    suspend fun getAlbumById(albumId: Long): AlbumEntity?

    /**
     * Retrieves an album and its associated tracks by album ID.
     *
     * @param albumId The unique identifier of the album.
     * @return A [Flow] emitting the [AlbumWithTracks] object, or null if not found.
     */
    @Transaction
    @Query("SELECT * FROM albums WHERE id = :albumId")
    fun getAlbumWithTracks(albumId: Long): Flow<AlbumWithTracks>
}
