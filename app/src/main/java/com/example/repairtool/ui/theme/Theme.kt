package com.example.repairtool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CorporateRedDark,
    primaryVariant = CorporateGreyDark,
    secondary = CorporateBlackDark,
    secondaryVariant = CorporateWhite,
    background = CorporateGreyDark
)

private val LightColorPalette = lightColors(
    primary = CorporateRed,
    primaryVariant = CorporateGrey,
    secondary = CorporateBlack,
    secondaryVariant = CorporateWhite,
    background = CorporateGrey

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun RepairToolTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}