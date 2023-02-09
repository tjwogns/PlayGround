package com.example.playground.content.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playground.content.compose.bottomNavigation.ui.theme.MyTheme

class Compose1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start) {
                    TextTest()

                    Column(modifier = Modifier.fillMaxWidth()) {
                        HelloContent()
                    }
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
                .size(20.dp)
                .padding(bottom = 16.dp),
            text = "Hello",
            textAlign = TextAlign.Center
        )
    }
}

data class NumTest(var num: Int)
//{
//    fun plusOne() {
//        num + 1
//    }
//}
@Composable
fun HelloContent() {

//    var numModelA by remember { mutableStateOf(NumTest(0)) }
//    var numModelB by remember { mutableStateOf(NumTest(0), neverEqualPolicy()) }
    var numModelB by remember { mutableStateOf(NumTest(0)) }
    var numModelC by remember { mutableStateOf(NumTest(0), neverEqualPolicy()) }
//    println("!!! DEBUG !!! numModel Hash : ${numModelA.hashCode()}")
    println("!!! DEBUG !!! numModel Hash : ${numModelB.hashCode()}")
//    println("!!! DEBUG !!! numModel Hash : ${numModelC.hashCode()}")
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Button(
            onClick = {
                numModelB = NumTest(++numModelB.num)
                numModelC = NumTest(1)


                println("!!! DEBUG !!! numModelB Hash2 : ${numModelB.hashCode()}")
            }
        ) {
            Text("Plus ${numModelB.num}")
        }

        Button(
            onClick = {
                println("!!! DEBUG !!! Button 2 numModelB.num [${numModelB.num}]")
            }
        ) {
            Text("Print Value")
        }

        Column() {
//            Text("Plus numModelA ${numModelA.num}")
            Text("Plus numModelB ${numModelB.num}")
            Text("Plus numModelC ${numModelC.num}")
//            Text("Plus numModelC ${numModelC.num}")
        }
    }
}