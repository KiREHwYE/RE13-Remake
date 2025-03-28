package com.kire.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kire.database.dao.AlbumDao
import com.kire.database.dao.PlaylistDao
import com.kire.database.dao.TrackDao
import com.kire.database.entity.AlbumEntity
import com.kire.database.entity.ArtistEntity
import com.kire.database.entity.PlaylistEntity
import com.kire.database.entity.PlaylistTrackCrossRef
import com.kire.database.entity.TrackEntity

/**
 * The main Room database for the application.
 * Defines the database configuration and provides access to data access objects (DAOs)
 * for managing tracks, albums, artists, playlists, and their relationships.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Database(
    entities = [TrackEntity::class, AlbumEntity::class, ArtistEntity::class, PlaylistEntity::class, PlaylistTrackCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Provides access to the [TrackDao] for managing track-related data.
     *
     * @return An instance of [TrackDao].
     */
    abstract fun trackDao(): TrackDao

    /**
     * Provides access to the [AlbumDao] for managing album-related data.
     *
     * @return An instance of [AlbumDao].
     */
    abstract fun albumDao(): AlbumDao

    /**
     * Provides access to the [PlaylistDao] for managing playlist-related data.
     *
     * @return An instance of [PlaylistDao].
     */
    abstract fun playlistDao(): PlaylistDao
}
