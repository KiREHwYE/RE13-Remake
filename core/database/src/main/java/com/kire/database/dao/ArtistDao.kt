package com.kire.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.kire.database.entity.ArtistEntity
import com.kire.database.model.AlbumWithTracks
import com.kire.database.model.ArtistWithTracks
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing artist-related data in the database.
 * Provides methods for upserting, deleting and querying artist entities.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Dao
interface ArtistDao {

    /**
     * Inserts or updates an artist entity in the database.
     * If the artist already exists, it will be updated; otherwise, it will be inserted.
     *
     * @param artist The [ArtistEntity] to upsert.
     */
    @Upsert
    suspend fun upsertArtist(artistEntity: ArtistEntity)

    /**
     * Deletes an artist entity from the database.
     *
     * @param artist The [ArtistEntity] to delete.
     */
    @Delete
    suspend fun deleteArtist(artistEntity: ArtistEntity)

    /**
     * Retrieves all artist entities from the database as a Flow.
     *
     * @return A [Flow] emitting a list of all [Artist] objects in the database.
     */
    @Query("SELECT * FROM artists")
    fun getAllArtists(): Flow<List<ArtistEntity>>

    /**
     * Retrieves an album entity by its unique identifier.
     *
     * @param artistId The unique identifier of the album.
     * @return The [ArtistEntity] with the specified [artistId], or null if no such artist exists.
     */
    @Query("SELECT * FROM artists WHERE id = :artistId")
    suspend fun getAlbumById(artistId: Long): ArtistEntity?

    /**
     * Retrieves an album and its associated tracks by album ID.
     *
     * @param albumId The unique identifier of the album.
     * @return A [Flow] emitting the [AlbumWithTracks] object, or null if not found.
     */
    @Transaction
    @Query("SELECT * FROM artists WHERE id = :artistId")
    fun getAlbumWithTracks(artistId: Long): Flow<ArtistWithTracks>
}