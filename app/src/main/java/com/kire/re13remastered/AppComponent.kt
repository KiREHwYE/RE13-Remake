package com.kire.re13remastered

import android.content.Context
import com.kire.data.di.DataModule
import com.kire.home.di.HomeModule
import com.kire.re13remastered.AppComponent.Builder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * The root Dagger component for the application, providing dependencies across all modules.
 * It supports injection into [MainActivity] and uses a [Builder] to bind
 * the application [Context] during component creation.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Singleton
@Component(modules = [DataModule::class, HomeModule::class])
interface AppComponent {
    /**
     * Injects dependencies into [MainActivity], providing access to the application's dependency graph.
     *
     * @param activity The [MainActivity] instance to inject dependencies into.
     */
    fun inject(activity: MainActivity)

    /**
     * Builder interface for constructing an [AppComponent] instance.
     * Allows binding of the application [Context] to the component during creation.
     */
    @Component.Builder
    abstract class Builder {

        /**
         * Binds the application [Context] to the component, typically the [Application] context.
         *
         * @param context The [Context] to bind, used for initializing dependencies like the database.
         * @return This [Builder] instance for chaining.
         */
        @BindsInstance
        abstract fun bindContext(context: Context): Builder

        /**
         * Builds and returns the fully configured [AppComponent] instance.
         *
         * @return The constructed [AppComponent].
         */
        abstract fun build(): AppComponent
    }

}