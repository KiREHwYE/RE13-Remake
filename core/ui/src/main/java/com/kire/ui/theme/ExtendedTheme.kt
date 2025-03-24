package com.kire.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kire.ui.R
import com.kire.ui.theme.color.ExtendedColor
import com.kire.ui.theme.font.ExtendedFont
import com.kire.ui.theme.type.ExtendedType

/**
 * Provides the local composition for [ExtendedColor], allowing access to the app's color palette
 * within the Compose hierarchy. Defaults to an empty [ExtendedColor] instance.
 */
val LocalExtendedColor = staticCompositionLocalOf { ExtendedColor() }

/**
 * Provides the local composition for [ExtendedType], allowing access to the app's typography styles
 * within the Compose hierarchy. Defaults to an empty [ExtendedType] instance.
 */
val LocalExtendedType = staticCompositionLocalOf { ExtendedType() }

/**
 * Provides the local composition for [ExtendedFont], allowing access to the app's font families
 * within the Compose hierarchy. Defaults to an empty [ExtendedFont] instance.
 */
val LocalExtendedFont = staticCompositionLocalOf { ExtendedFont() }

/**
 * Defines the default color palette for the application using [ExtendedColor].
 * Contains specific color values for UI elements.
 */
val extendedColor = ExtendedColor(
    background = Color(0xFFF5F5F5), // Light grey background
    red = Color(0xFFE30000),        // Vibrant red accent
    pink = Color(0xFFF2EEEE),       // Soft pink accent
    black = Color.Black,            // Standard black
    white = Color.White,            // Standard white
    grey1 = Color(0xFFB5B5B5),      // Medium grey
    grey2 = Color(0xFFEBEBEB)       // Light grey variant
)

/**
 * Defines the default font family for the application using [ExtendedFont].
 */
val extendedFont = ExtendedFont(
    rubikFamily = FontFamily(
        Font(R.font.rubik_regular, FontWeight.W400)
    )
)

/**
 * Defines the default typography styles for the application using [ExtendedType].
 * Specifies text styles with font sizes and the Rubik font family.
 */
val extendedType = ExtendedType(
    text1 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.rubikFamily
    ),
    text2 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        fontFamily = extendedFont.rubikFamily
    )
)

/**
 * A custom Compose theme that applies extended styling to the application.
 * Provides [ExtendedColor], [ExtendedFont], and [ExtendedType] via [CompositionLocalProvider]
 * and wraps content in the [RE13RemasteredTheme].
 *
 * @param content The composable content to be themed.
 *
 * @author Michael Gontarev (KiREHwYE)
 */
@Composable
fun RE13RemakeExtendedTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

    CompositionLocalProvider(
        LocalExtendedColor provides extendedColor,
        LocalExtendedFont provides extendedFont,
        LocalExtendedType provides extendedType
    ) {
        RE13RemasteredTheme {
            content()
        }
    }
}

/**
 * Provides access to the extended theme properties within the Compose hierarchy.
 * Exposes [ExtendedColor], [ExtendedFont], and [ExtendedType] through composition locals.
 */
object ExtendedTheme {
    /**
     * The current [ExtendedColor] instance from the composition local.
     */
    val extendedColor: ExtendedColor
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColor.current

    /**
     * The current [ExtendedFont] instance from the composition local.
     */
    val extendedFont: ExtendedFont
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedFont.current

    /**
     * The current [ExtendedType] instance from the composition local.
     */
    val extendedType: ExtendedType
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedType.current
}