package com.example.playground.content.compose.bottomNavigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.playground.content.compose.ComposeViewModel
import com.example.playground.content.compose.bottomNavigation.graph.RootNavigationGraph
import com.example.playground.content.compose.bottomNavigation.ui.theme.PlayGroundTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * BottomSheet Navigation Test
 * 참고 영상 : https://www.youtube.com/watch?v=gNzPGI9goU0
 */
class ComposeExampleActivity: AppCompatActivity() {
    val viewModel: ComposeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            PlayGroundTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}