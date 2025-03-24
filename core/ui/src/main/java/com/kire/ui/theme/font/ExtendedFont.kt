package com.kire.ui.theme.font

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

/**
 * Represents a collection of predefined font families used throughout the application.
 * Fonts are based on [FontFamily] from Jetpack Compose.
 *
 * @property rubikFamily The Rubik font family for general text usage across the app.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Immutable
data class ExtendedFont(
    val rubikFamily: FontFamily = FontFamily()
)
