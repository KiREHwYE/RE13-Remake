package com.kire.di

import javax.inject.Qualifier

/**
 * Dagger qualifier annotation used to indicate the [Dispatchers.IO] coroutine dispatcher
 * in dependency injection. Marks a dependency as intended for I/O-bound operations.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

/**
 * Dagger qualifier annotation used to indicate the [Dispatchers.Default] coroutine dispatcher
 * in dependency injection. Marks a dependency as intended for CPU-bound or default tasks.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher