package com.kire.data.di

import android.content.Context
import com.kire.data.DatabaseUpdater
import com.kire.database.di.DatabaseModule
import com.kire.di.CoroutineModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component that provides data-related dependencies in the `:core:data` module.
 * This component exposes the [DatabaseUpdater] instance for synchronizing audio file metadata
 * with the local Room database, relying on dependencies defined in [DataModule] and
 * optionally other modules like [DatabaseModule] from `:core:database`.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Singleton
@Component(modules = [DatabaseModule::class, CoroutineModule::class])
interface DataComponent {

    /**
     * Provides an instance of [DatabaseUpdater] for updating the local Room database with
     * audio file metadata retrieved from the device's MediaStore.
     *
     * @return The [DatabaseUpdater] instance configured with dependencies from [DataModule].
     */
    fun provideDatabaseUpdater(): DatabaseUpdater

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder
        fun build(): DataComponent
    }
}