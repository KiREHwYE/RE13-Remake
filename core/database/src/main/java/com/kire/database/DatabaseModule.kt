package com.kire.database

import android.content.Context
import androidx.room.Room
import com.kire.database.dao.AlbumDao
import com.kire.database.dao.PlaylistDao
import com.kire.database.dao.TrackDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module responsible for providing database-related dependencies.
 * Supplies the application database and data access objects (DAOs) for tracks, playlists, and albums.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Module
object DatabaseModule {

    /**
     * Provides the main Room database instance for the application.
     * The database is configured as a singleton to ensure a single instance throughout the app lifecycle.
     *
     * @param context The [Context] used to initialize the database, typically the application context.
     * @return An instance of [AppDatabase] configured with destructive migration fallback.
     */
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "music_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Provides the data access object for track-related operations.
     *
     * @param db The [AppDatabase] instance from which the DAO is obtained.
     * @return An instance of [TrackDao] for managing track data.
     */
    @Provides
    fun provideTrackDao(db: AppDatabase): TrackDao {
        return db.trackDao()
    }

    /**
     * Provides the data access object for playlist-related operations.
     *
     * @param db The [AppDatabase] instance from which the DAO is obtained.
     * @return An instance of [PlaylistDao] for managing playlist data.
     */
    @Provides
    fun providePlaylistDao(db: AppDatabase): PlaylistDao {
        return db.playlistDao()
    }

    /**
     * Provides the data access object for album-related operations.
     *
     * @param db The [AppDatabase] instance from which the DAO is obtained.
     * @return An instance of [AlbumDao] for managing album data.
     */
    @Provides
    fun provideAlbumDao(db: AppDatabase): AlbumDao {
        return db.albumDao()
    }
}