package com.kire.re13remastered

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kire.home.presentation.navigation.HomeRoutes
import com.kire.home.presentation.navigation.homeNavGraph
import com.kire.home.presentation.viewmodel.HomeViewModel

/**
 * The main navigation host for the application, setting up the top-level navigation structure.
 * This composable uses [NavHost] to manage navigation between different features, starting with
 * the Home screen as the initial destination.
 *
 * @param navHostController The [NavHostController] used to control navigation across the app.
 * @param homeViewModel The [HomeViewModel] providing track data for the Home feature.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun MainNavHost(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel
) {
    NavHost(navController = navHostController, startDestination = HomeRoutes.Home.route) {
        homeNavGraph(navController = navHostController, homeViewModel = homeViewModel)
    }
}