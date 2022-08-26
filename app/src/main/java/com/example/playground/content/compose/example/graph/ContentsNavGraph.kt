package com.example.playground.content.compose.example.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.playground.content.compose.bottomNavigation.ui.ScreenContent
import com.example.playground.content.compose.example.ComposeToyViewModel
import com.example.playground.content.compose.example.ToyBottomNavigation
import com.example.playground.content.compose.example.screen.HospitalScreen

@Composable
fun ContentsNavGraph(navController: NavHostController, viewModel: ComposeToyViewModel = ComposeToyViewModel()) {
    println("!!! DEBUG !!! Called???")
    val context = LocalContext.current

    val data = viewModel.getSingInfo().collectAsState(initial = listOf())

    NavHost(
        navController = navController,
        route = Graph.CONTENTS,
        startDestination = ToyBottomNavigation.Home.route
    ) {
        composable(route = ToyBottomNavigation.Home.route) {
            ScreenContent(name = "CONTENTS HOME !!!") {

            }

        }
        composable(route = ToyBottomNavigation.Hospital.route) {
            HospitalScreen(context, data)
        }

        composable(route = ToyBottomNavigation.Abandoned.route) {
            ScreenContent(name = ToyBottomNavigation.Abandoned.title) {

            }
        }
    }
}