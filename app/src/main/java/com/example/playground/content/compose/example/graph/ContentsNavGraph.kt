package com.example.playground.content.compose.example.graph

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.playground.content.compose.bottomNavigation.ui.ScreenContent
import com.example.playground.content.compose.example.ComposeToyViewModel
import com.example.playground.content.compose.example.ToyBottomNavigation
import com.example.playground.content.compose.example.screen.HomeScreen
import com.example.playground.content.compose.example.screen.HospitalScreen
import com.example.playground.dto.HospitalDto
import com.example.playground.dto.HospitalResult
import com.example.playground.dto.HosptlDto

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContentsNavGraph(navController: NavHostController, viewModel: ComposeToyViewModel = ComposeToyViewModel()) {
    val context = LocalContext.current

//    val data = viewModel.getSingInfo().collectAsState(initial = listOf())
    val data = viewModel.getHospital().collectAsState(initial = HospitalResult())

    NavHost(
        navController = navController,
        route = Graph.CONTENTS,
        startDestination = ToyBottomNavigation.Home.route
    ) {
        composable(route = ToyBottomNavigation.Home.route) {
            HomeScreen(navController)
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