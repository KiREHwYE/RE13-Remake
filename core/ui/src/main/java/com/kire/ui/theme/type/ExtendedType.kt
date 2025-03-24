package com.kire.ui.theme.type

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

/**
 * Represents a collection of predefined text styles used throughout the application.
 * Styles are based on [TextStyle] from Jetpack Compose.
 *
 * @property text1 The style for primary body text, such as song title.
 * @property text2 The style for secondary body text, slightly smaller than [text1], used for additional details or supporting information, such as song's author and album.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Immutable
data class ExtendedType(
    val text1: TextStyle = TextStyle(),
    val text2: TextStyle = TextStyle()
)
