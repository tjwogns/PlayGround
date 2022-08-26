package com.example.playground.content.compose.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.playground.content.compose.bottomNavigation.ui.theme.PlayGroundTheme
import com.example.playground.content.compose.example.graph.RootNavGraph
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComposeToyActivity: AppCompatActivity() {
    val viewModel: ComposeToyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlayGroundTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}