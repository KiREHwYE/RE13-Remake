package com.kire.re13remastered

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kire.ui.Dimens.Padding.horizontal2
import com.kire.ui.Dimens.Padding.vertical4

/**
 * A composable that displays a top bar with a vertical arrangement of items.
 *
 * The top bar arranges the provided [items] in a [Column], with vertical spacing defined by [vertical4].
 * It is typically used to display elements like a search bar, title, or action buttons at the top of a screen.
 *
 * @param modifier The modifier to apply to the top bar. Defaults to [Modifier].
 * @param items A vararg of composables to be displayed in the top bar. Defaults to an empty array.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    vararg items: @Composable () -> Unit = arrayOf()
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = vertical4, horizontal = horizontal2),
        verticalArrangement = Arrangement.spacedBy(vertical4)
    ) {
        items.forEach { item ->
            item()
        }
    }
}