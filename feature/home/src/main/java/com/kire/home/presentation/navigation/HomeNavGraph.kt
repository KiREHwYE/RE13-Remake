package com.kire.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kire.home.presentation.screen.HomeScreen
import com.kire.home.presentation.viewmodel.HomeViewModel

/**
 * Sets up the navigation graph for the Home feature within a [NavGraphBuilder].
 * This function defines the navigation routes for the Home feature.
 *
 * @param navController The [NavController] used for navigating between screens.
 * @param homeViewModel The [HomeViewModel] providing track data for the Home screen.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    composable(HomeRoutes.Home.route) {
        HomeScreen(
            homeViewModel = homeViewModel,
            navController = navController
        )
    }
}