package com.kire.data.di

import com.kire.data.DatabaseUpdater
import com.kire.database.di.DatabaseComponent
import dagger.Component

/**
 * Dagger component that provides data-related dependencies in the `:core:data` module.
 * This component exposes the [DatabaseUpdater] instance for synchronizing audio file metadata
 * with the local Room database, relying on dependencies defined in [DataModule] and
 * optionally other modules like [DatabaseModule] from `:core:database`.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Component(dependencies = [DatabaseComponent::class])
interface DataComponent {

    /**
     * Provides an instance of [DatabaseUpdater] for updating the local Room database with
     * audio file metadata retrieved from the device's MediaStore.
     *
     * @return The [DatabaseUpdater] instance configured with dependencies from [DataModule].
     */
    fun provideDatabaseUpdater(): DatabaseUpdater
}