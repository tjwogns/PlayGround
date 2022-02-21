package com.example.playground.content.sso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.playground.content.compose.ui.theme.MyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class SsoActivity : ComponentActivity() {
    val viewModel: SsoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {

            }
        }
    }
}