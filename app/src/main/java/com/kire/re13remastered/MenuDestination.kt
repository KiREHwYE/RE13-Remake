package com.kire.re13remastered

import com.kire.home.presentation.navigation.HomeRoutes

/**
 * Represents destinations in the app's navigation menu.
 *
 * Each destination has a [route] for navigation and a [label] for display in the UI. The [route] can be
 * null if the destination is not yet implemented or does not require navigation.
 *
 * @property route The navigation route for the destination, or null if not applicable.
 * @property label The display label for the destination in the UI.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
enum class MenuDestination(
    val route: String?,
    val label: String
) {
    /**
     * The "Home" destination, representing the main screen with a list of songs.
     */
    HOME(HomeRoutes.Home.route, "Songs"),

    /**
     * The "Artists" destination, representing the screen for browsing artists (not yet implemented).
     */
    ARTISTS(null, "Artists"),

    /**
     * The "Albums" destination, representing the screen for browsing albums (not yet implemented).
     */
    ALBUMS(null, "Albums"),

    /**
     * The "Playlists" destination, representing the screen for browsing playlists (not yet implemented).
     */
    PLAYLISTS(null, "Playlists")
}