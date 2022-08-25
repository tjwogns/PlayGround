package com.example.playground.content.compose.example.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.playground.content.compose.bottomNavigation.ui.ScreenContent
import com.example.playground.content.compose.example.ToyBottomNavigation

@Composable
fun ContentsNavGraph(navController: NavHostController) {
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
            ScreenContent(name = ToyBottomNavigation.Hospital.title) {

            }
        }

        composable(route = ToyBottomNavigation.Abandoned.route) {
            ScreenContent(name = ToyBottomNavigation.Abandoned.title) {

            }
        }
    }
}

fun NavGraphBuilder.contentsNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.CONTENTS
//    ) {
//
//    }
}