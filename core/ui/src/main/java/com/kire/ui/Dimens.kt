package com.kire.ui

import androidx.compose.ui.unit.dp

/**
 * Object containing dimension constants for UI layout in the application.
 * Provides a structured set of predefined sizes in density-independent pixels (dp) for padding, corner radius,
 * and UI element dimensions. The constants are grouped into nested objects for better organization and clarity.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
object Dimens {

    /**
     * Object containing padding-related dimension constants.
     * Defines standard padding values used for spacing UI elements along horizontal and vertical axes.
     */
    object Padding {
        val horizontal1 = 16.dp
        val horizontal2 = 24.dp

        val vertical1 = 16.dp
        val vertical2 = 24.dp
    }

    /**
     * Object containing corner radius-related dimension constants.
     * Defines standard corner radius values for rounded UI elements, such as cards or images.
     */
    object Corners {
        val rounded1 = 16.dp
    }

    /**
     * Object containing size-related dimension constants.
     * Defines standard sizes for UI elements, such as artwork images or icons.
     */
    object Sizes {
        val artwork1 = 52.dp
    }
}