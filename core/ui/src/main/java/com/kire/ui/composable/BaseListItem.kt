package com.kire.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import coil3.compose.AsyncImage
import com.kire.ui.Dimens.Corners.rounded1
import com.kire.ui.Dimens.Padding.horizontal2
import com.kire.ui.Dimens.Sizes.artwork1
import com.kire.ui.R
import com.kire.ui.theme.extendedType

/**
 * A composable UI component representing a single list item with text, artwork, and an action button.
 * This component is designed for use in lists, such as track listings, featuring a clickable row with an
 * artwork image, primary and secondary text fields, and an action icon..
 *
 * @param modifier The [Modifier] to apply to the entire composable, defaults to an empty [Modifier].
 * @param primaryText The primary text to display, typically larger or more prominent (e.g., track title); defaults to an empty string.
 * @param secondaryText The secondary text to display, typically smaller or less prominent (e.g., artist name); defaults to an empty string.
 * @param artwork The artwork URI or path as a nullable [String], displayed as an image; if null, a fallback image is shown.
 * @param onBaseListItemClick The callback invoked when the entire list item is clicked; defaults to an empty lambda.
 * @param onActionButtonClick The callback invoked when the action icon (menu) is clicked; defaults to an empty lambda.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun BaseListItem(
    modifier: Modifier = Modifier,
    primaryText: String = "",
    secondaryText: String = "",
    artwork: String? = null,
    onBaseListItemClick: () -> Unit = {},
    onActionButtonClick: () -> Unit = {}
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onBaseListItemClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(horizontal2)
    ) {
        AsyncImage(
            model = artwork,
            contentDescription = "Artwork",
            error = painterResource(R.drawable.artwork_placeholder),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(artwork1)
                .clip(RoundedCornerShape(rounded1))
        )

        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = primaryText,
                style = extendedType.text1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = secondaryText,
                style = extendedType.text2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Icon(
            painter = painterResource(R.drawable.menu),
            contentDescription = "Menu",
            modifier = Modifier
                .clickable {
                    onActionButtonClick()
                }
        )
    }
}