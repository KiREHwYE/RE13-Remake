package com.kire.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.kire.ui.Dimens.Padding.horizontal1
import com.kire.ui.Dimens.Padding.vertical1

/**
 * A foundational layout composable that arranges its children in a vertical column with a top bar,
 * main content, and bottom bar. This layout ensures proper handling of system insets (e.g., status bar,
 * navigation bar, and IME) and applies consistent spacing and padding for a cohesive UI structure.
 *
 * @param modifier The [Modifier] to be applied to the layout. Defaults to an empty [Modifier].
 * @param contentSpacing Vertical spacing between the layout's children. Defaults to [vertical1].
 * @param topBar A composable lambda that defines the top bar content, such as a toolbar or header. Defaults to empty lambda.
 * @param bottomBar A composable lambda that defines the bottom bar content, such as a navigation bar.Defaults to empty lambda.
 * @param content A composable lambda that defines the main content of the layout, displayed between
 *                the top bar and bottom bar.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun BaseLayout(
    modifier: Modifier = Modifier,
    contentSpacing: Dp = vertical1,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.ime)
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(contentSpacing)
    ) {
        topBar()
        content()
        bottomBar()
    }
}