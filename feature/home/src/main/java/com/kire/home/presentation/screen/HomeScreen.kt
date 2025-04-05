package com.kire.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.kire.home.presentation.viewmodel.HomeViewModel
import com.kire.ui.Dimens.Padding.horizontal2
import com.kire.ui.Dimens.Padding.vertical2
import com.kire.ui.composable.BaseListItem

/**
 * A composable screen that displays a list of tracks.
 * This screen uses a [LazyColumn] , with each track represented by a [BaseListItem].
 * The track data is fetched reactively from [HomeViewModel] and
 * updates automatically when the underlying data changes.
 *
 * @param homeViewModel The [HomeViewModel] instance providing the track data as a [Flow] of
 *                      [Track] objects.
 * @param navController NavController for navigation.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val tracks by homeViewModel.tracks.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = horizontal2),
        verticalArrangement = Arrangement.spacedBy(vertical2),
        contentPadding = PaddingValues(vertical = vertical2)
    ) {
        items(tracks, key = { track -> track.id} ) { track ->

            BaseListItem(
                primaryText = track.title,
                secondaryText = track.artistName + "-" + track.albumTitle,
                artwork = track.artworkUri,
                onBaseListItemClick = {
                    // TODO
                },
                onActionButtonClick = {
                    // TODO
                }
            )
        }
    }
}