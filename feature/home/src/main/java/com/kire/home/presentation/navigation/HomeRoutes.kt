package com.kire.home.presentation.navigation

/**
 * Defines navigation routes for the Home feature in the application.
 * This sealed class provides a type-safe way to specify destinations within the Home module,
 * intended for use with Jetpack Compose Navigation.
 *
 * Example usage with NavHost:
 * ```
 * NavHost(navController = navController, startDestination = HomeRoutes.Home.route) {
 *     composable(HomeRoutes.Home.route) {
 *         HomeScreen(homeViewModel = homeViewModel, navController = navController)
 *     }
 * }
 * ```
 *
 * @param route The unique string identifier for the navigation destination.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
sealed class HomeRoutes(val route: String) {

    /**
     * Represents the Home screen destination, which displays a list of tracks.
     */
    object Home: HomeRoutes("home")
}