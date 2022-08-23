package com.example.playground.content.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playground.content.compose.ui.theme.PlayGroundTheme
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
                Surface(color = MaterialTheme.colors.background) {
                    getNav()
                }
            }
        }
    }
}

@Composable
fun getNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            Profile(navController = navController)
        }
    }
}

@Composable
fun Profile(navController: NavController) {
    Surface(color = Color.Blue) {
        Text(text = "Hi")
    }
}