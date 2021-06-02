package com.example.playground.compose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

//        setContent {
//            Greeting("Android")
//        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text (text = "Hello $name")
//}