package com.kire.ui.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Represents a collection of predefined colors used throughout the application.
 * Colors are based on [Color] from Jetpack Compose.
 *
 * @property background The color used for background surfaces.
 * @property red The primary red color for accents or highlights.
 * @property pink The primary pink color for accents or thematic elements.
 * @property black The primary black color for text or dark UI components.
 * @property white The primary white color for text or light UI components.
 * @property grey1 The primary grey color for subtle accents or secondary elements.
 * @property grey2 A lighter or darker variant of grey for additional contrast.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Immutable
data class ExtendedColor(
    val background: Color = Color.Unspecified,
    val red: Color = Color.Unspecified,
    val pink: Color = Color.Unspecified,
    val black: Color = Color.Unspecified,
    val white: Color = Color.Unspecified,
    val grey1: Color = Color.Unspecified,
    val grey2: Color = Color.Unspecified
)