package com.example.playground.content.compose.example.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.playground.content.compose.example.screen.ContentsScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.CONTENTS
    ) {
        composable(route = Graph.CONTENTS) {
            ContentsScreen()
        }
    }

}
object Graph {
    const val ROOT = "root_graph"
    const val CONTENTS = "contents_graph"
}