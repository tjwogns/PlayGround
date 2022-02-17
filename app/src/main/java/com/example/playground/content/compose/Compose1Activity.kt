package com.example.playground.content.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playground.content.compose.ui.theme.MyTheme

class Compose1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    TextTest()
                }
            }
        }
    }
}

@Preview
@Composable
fun TextTest() {
    Surface(color = Color.Magenta) {
        Text(
            modifier = Modifier
                .width(150.dp)
                .size(20.dp),
            text = "Hello",
            textAlign = TextAlign.Center
        )
    }
}