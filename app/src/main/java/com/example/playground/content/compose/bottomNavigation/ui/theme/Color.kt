package com.example.playground.content.compose.bottomNavigation.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Navy500 = Color(0xFF64869B)
val Navy700 = Color(0xFF37596D)
val Navy900 = Color(0xFF073042)
val Green300 = Color(0xFF3DDC84)
val Green900 = Color(0xFF00A956)

val LightColors = lightColors(
    primary = Navy700,
    primaryVariant = Navy900,
    secondary = Green300,
    secondaryVariant = Green900
    // Using default values for onPrimary, surface, error, etc.
)

val DarkColors = darkColors(
    primary = Navy500,
    primaryVariant = Navy900,
    secondary = Green300
    // secondaryVariant == secondary in dark theme
)
