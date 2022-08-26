package com.example.playground.content.compose.example.screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playground.content.compose.example.ComposeToyViewModel
import com.example.playground.dto.KaraokeDto

@Composable
fun HospitalScreen(context: Context, data: State<List<KaraokeDto>>) {

    Karaokes(context = context, singInfo = data.value)
}

@Composable
fun Karaokes(context: Context, singInfo: List<KaraokeDto>) {
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(items = singInfo) { sing ->
            SingCard(item = sing)
        }
    }
}

@Composable
fun SingCard(item: KaraokeDto) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
         Column(
             modifier = Modifier
                 .padding(12.dp)
         ) {
            Text(text = item.brand)
            Text(text = "번  호 : ${item.no}")
            Text(text = "제  목 : ${item.title}")
            Text(text = "가  수 : ${item.singer}")
            Text(text = "작곡가 : ${item.composer}")
            Text(text = "작사가 : ${item.lyricist}")
            Text(text = "발매일 : ${item.release}")
         }
    }
}