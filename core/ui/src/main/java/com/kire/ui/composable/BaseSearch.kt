package com.kire.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.kire.ui.Dimens.Corners.rounded1
import com.kire.ui.Dimens.Padding.horizontal2
import com.kire.ui.Dimens.Padding.vertical1
import com.kire.ui.R
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * A composable that displays a search bar with an icon and a text field for searching local music.
 *
 * @param modifier The modifier to apply to the search bar. Defaults to [Modifier].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun BaseSearch(
    modifier: Modifier = Modifier
) {
    var searchText by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(rounded1))
            .background(color = extendedColor.white)
            .padding(vertical = vertical1, horizontal = horizontal2),
        horizontalArrangement = Arrangement.spacedBy(horizontal2)
    ) {

        Icon(
            painter = painterResource(R.drawable.search),
            contentDescription = "Search local music",
            tint = extendedColor.grey1
        )

        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            maxLines = 1,
            decorationBox = { innerTextField ->
                if (searchText.isEmpty())
                    Text(
                        text = "Search local music",
                        style = extendedType.text1,
                        color = extendedColor.grey1
                    )
                innerTextField()

            },
            modifier = Modifier
                .weight(1f)
        )
    }
}