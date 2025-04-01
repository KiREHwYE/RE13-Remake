package com.kire.data.di

import android.content.Context
import com.kire.data.DatabaseUpdater
import com.kire.data.audio_reader.AudioReader
import com.kire.database.dao.AlbumDao
import com.kire.database.dao.ArtistDao
import com.kire.database.dao.TrackDao
import com.kire.di.IODispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

/**
 * Dagger module that provides dependencies for data-related operations in the `:core:data` module.
 * This module supplies instances of [AudioReader] and [DatabaseUpdater] for retrieving audio file metadata
 * from the device's MediaStore and synchronizing it with the local Room database.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Module
object DataModule {

    /**
     * Provides [AudioReader] class that reads audio file metadata from the device's media store for storage in the local database.
     *
     * @param context The [Context] used to initialize the database, typically the application context.
     * @return An instance of [AudioReader] for managing audio files.
     */
    @Provides
    @Singleton
    fun provideAudioReader(context: Context): AudioReader {
        return AudioReader(context)
    }

    /**
     * Provides [DatabaseUpdater] class that updates the local Room database with audio file metadata retrieved from the device's MediaStore.
     *
     * @param audioReader The [AudioReader] instance to fetch audio file metadata.
     * @param trackDao The [TrackDao] for managing track entities.
     * @param artistDao The [ArtistDao] for managing artist entities.
     * @param albumDao The [AlbumDao] for managing album entities.
     * @param coroutineDispatcher The [CoroutineDispatcher] annotated with [@IODispatcher] for I/O-bound tasks.
     *
     * @return An instance of [DatabaseUpdater] for managing database updates.
     */
    @Provides
    @Singleton
    fun provideDatabaseUpdater(
        audioReader: AudioReader,
        trackDao: TrackDao,
        artistDao: ArtistDao,
        albumDao: AlbumDao,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): DatabaseUpdater {
        return DatabaseUpdater(audioReader, trackDao, artistDao, albumDao, coroutineDispatcher)
    }
}