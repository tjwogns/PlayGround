package com.example.playground.content.compose.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ToyBottomNavigation(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: ToyBottomNavigation(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )
    object Hospital: ToyBottomNavigation(
        route = "HOSPITAL",
        title = "HOSPITAL",
        icon = Icons.Default.LocalHospital
    )
    object Abandoned: ToyBottomNavigation(
        route = "ABANDONED",
        title = "ABANDONED",
        icon = Icons.Default.Search
    )
}