package com.example.playground.content.compose.example

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.playground.content.compose.bottomNavigation.ui.theme.PlayGroundTheme
import com.example.playground.content.compose.example.graph.RootNavGraph

class ComposeToyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlayGroundTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}