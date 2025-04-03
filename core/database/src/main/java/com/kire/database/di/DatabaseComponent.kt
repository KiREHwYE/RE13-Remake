package com.kire.database.di

import android.content.Context
import com.kire.database.AppDatabase
import com.kire.database.dao.AlbumDao
import com.kire.database.dao.ArtistDao
import com.kire.database.dao.PlaylistDao
import com.kire.database.dao.TrackDao
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component providing database-related dependencies.
 * Exposes DAOs and the database instance to be used across various modules.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    /**
     * Provides the main Room database instance.
     *
     * @return An instance of [AppDatabase].
     */
    fun getDatabase(): AppDatabase

    /**
     * Provides the data access object for track-related operations.
     *
     * @return An instance of [TrackDao].
     */
    fun getTrackDao(): TrackDao

    /**
     * Provides the data access object for playlist-related operations.
     *
     * @return An instance of [PlaylistDao].
     */
    fun getPlaylistDao(): PlaylistDao

    /**
     * Provides the data access object for album-related operations.
     *
     * @return An instance of [AlbumDao].
     */
    fun getAlbumDao(): AlbumDao

    /**
     * Provides the data access object for artist-related operations.
     *
     * @return An instance of [ArtistDao].
     */
    fun getArtistDao(): ArtistDao

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder
        fun build(): DatabaseComponent
    }
}