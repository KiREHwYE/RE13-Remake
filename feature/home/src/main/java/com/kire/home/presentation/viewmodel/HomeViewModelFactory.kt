package com.kire.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kire.home.di.HomeComponent
import com.kire.home.domain.usecase.ITrackUseCases
import javax.inject.Inject

/**
 * Factory for creating [HomeViewModel] instances using Dagger dependency injection.
 * This class implements [ViewModelProvider.Factory] to provide a [HomeViewModel].
 *
 * @param trackUseCases A collection of use cases related to track management.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
class HomeViewModelFactory @Inject constructor(
    private val trackUseCases: ITrackUseCases
) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the specified ViewModel class.
     *
     * @param modelClass The class of the ViewModel to create.
     * @return A newly created [HomeViewModel] instance if the class matches, otherwise throws an exception.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(trackUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}