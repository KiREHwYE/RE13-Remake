package com.kire.di

import dagger.Module
import dagger.Provides

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Dagger module responsible for providing coroutine dispatchers as dependencies.
 * Supplies [CoroutineDispatcher] instances for various threading contexts using
 * [kotlinx.coroutines.Dispatchers].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Module
object CoroutineModule {

    /**
     * Provides the [Dispatchers.IO] coroutine dispatcher for I/O-bound operations.
     * Suitable for tasks such as file I/O, network requests, or database operations.
     *
     * @return A [CoroutineDispatcher] instance configured for I/O tasks.
     */
    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    /**
     * Provides the [Dispatchers.Default] coroutine dispatcher for CPU-bound or default tasks.
     * Suitable for general-purpose computations that do not require the main thread.
     *
     * @return A [CoroutineDispatcher] instance configured for default threading.
     */
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}