package com.kire.re13remastered

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kire.ui.Dimens.Padding.horizontal2
import com.kire.ui.R
import com.kire.ui.composable.BaseSearch
import com.kire.ui.theme.extendedColor

/**
 * A composable that combines a search bar and a menu icon in a single row.
 *
 * The component displays a [BaseSearch] composable for searching local music and an [Icon] for opening the
 * menu. The menu icon currently has a placeholder action (TODO) that should be implemented to handle menu
 * interactions.
 *
 * @param modifier The modifier to apply to the row. Defaults to [Modifier].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun SearchWithMenu(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(horizontal2)
    ) {
        BaseSearch(Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.menu),
            contentDescription = "Menu",
            tint = extendedColor.black,
            modifier = Modifier
                .clickable {
                    // TODO
                }
        )
    }
}