package com.kire.re13remastered

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kire.ui.Dimens.Padding.vertical4
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * A composable that displays a navigation menu with clickable destinations.
 *
 * The menu displays a list of destinations from [MenuDestination], with each item represented by a [Text]
 * component. The currently selected destination is highlighted in red, while others are displayed in black.
 * Clicking on a destination navigates to its route using the provided [NavController].
 *
 * @param navController The [NavController] used to navigate between destinations.
 * @param modifier The modifier to apply to the menu. Defaults to [Modifier].
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun NavigationMenu(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MenuDestination.entries.forEach { menuDestination ->
            Text(
                text = menuDestination.label,
                style = extendedType.text1,
                color = if (currentRoute == menuDestination.route) extendedColor.red else extendedColor.black,
                modifier = Modifier
                    .pointerInput(currentRoute == menuDestination.route) {
                        detectTapGestures {
                            menuDestination.route?.let { route ->
                                navController.navigate(route)
                            }
                        }
                    }
            )
        }
    }
}