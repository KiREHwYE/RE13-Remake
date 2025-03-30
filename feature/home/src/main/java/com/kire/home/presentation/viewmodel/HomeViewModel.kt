package com.kire.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kire.home.domain.usecase.ITrackUseCases
import com.kire.home.presentation.mapper.to_presentation.toPresentation
import com.kire.home.presentation.model.Track
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the home feature, managing the state of track data for the UI.
 * This class uses [ITrackUseCases] for track-related operations.
 *
 * @param trackUseCases The [ITrackUseCases] instance providing track-related use cases.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
class HomeViewModel(
    private val trackUseCases: ITrackUseCases
) : ViewModel() {

    /**
     * Mutable state flow holding the current list of tracks for internal updates.
     * Initialized with an empty list, this flow is updated with track data fetched from [ITrackUseCases].
     */
    private val _tracks: MutableStateFlow<List<Track>> = MutableStateFlow(emptyList())

    /**
     * Public state flow exposing the list of tracks for UI observation.
     * This flow provides a read-only view of [_tracks], allowing the UI to reactively display the current
     * list of [Track] objects as they are updated.
     */
    val tracks: StateFlow<List<Track>> = _tracks.asStateFlow()

    init {
        getAllTracks()
    }

    /**
     * Fetches all tracks from the database and updates the [_tracks] state flow.
     * Launches a coroutine in [viewModelScope] to collect the [Flow] of [TrackDomain] objects from
     * [ITrackUseCases.getAllTracksUseCase], converts them to presentation [Track] objects using
     * [List<TrackDomain>.toPresentation], and updates the [_tracks] value for UI consumption.
     */
    private fun getAllTracks() {
        viewModelScope.launch {
            trackUseCases.getAllTracksUseCase()
                .collect { listOfTrackDomain ->
                    _tracks.value = listOfTrackDomain.toPresentation()
                }
        }
    }
}