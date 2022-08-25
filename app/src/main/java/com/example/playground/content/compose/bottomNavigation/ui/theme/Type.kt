package com.example.playground.content.compose.bottomNavigation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography2 = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)


val H6 = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    letterSpacing = 0.15.sp
)
val Body2 = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.25.sp
)
val Button = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 1.25.sp
)

val Typography = Typography(
    h6 = H6,
    body2 = Body2,
    button = Button,
//    defaultFontFamily = FontFamily(Font(R.font.roboto_mono))
    // Using default values for subtitle1, caption, etc.
)