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
import com.example.playground.dto.HospitalDto
import com.example.playground.dto.HospitalRowDto
import com.example.playground.dto.KaraokeDto

@Composable
fun HospitalScreen(context: Context, data: State<HospitalDto>) {

//    Karaokes(context = context, singInfo = data.value)
    Hospitals(context = context, hospitals = data.value)
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
fun Hospitals(context: Context, hospitals: HospitalDto) {
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(items = hospitals.row ?: listOf()) { hospital ->
            HospitalCard(item = hospital)
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

@Composable
fun HospitalCard(item: HospitalRowDto) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
         Column(
             modifier = Modifier
                 .padding(12.dp)
         ) {
            Text(text = "시군 코드 : ${item.sicunCode}")
            Text(text = "시군 명 : ${item.sicunName}")
            Text(text = "사업장 명 : ${item.workplaceName}")
            Text(text = "인허가일자 : ${item.licenseDate}")
            Text(text = "영업상태구분코드 : ${item.businessStateCode}")
            Text(text = "영업상태명 : ${item.businessStateName}")
            Text(text = "소재지 전화번호 : ${item.localFactoryTelNumber}")
            Text(text = "소재지 면적정보 : ${item.localAreaInfo}")
            Text(text = "소재지 우편번호 : ${item.localZipCode}")
            Text(text = "도로명 우편번호 : ${item.roadNameZipCode}")
            Text(text = "도로명 주소 : ${item.refineRoadNameAddress}")
            Text(text = "지번 주소 : ${item.refineLocalAddress}")
            Text(text = "우편 번호 : ${item.refineZipCode}")
            Text(text = "WGS84 위도 : ${item.latitude}")
            Text(text = "WGS84 경도 : ${item.longitude}")
            Text(text = "X 좌표값 : ${item.xCoordinate}")
            Text(text = "Y 좌표값 : ${item.yCoordinate}")
            Text(text = "총 종업원 수 : ${item.totalEmployeeCount}")
         }
    }
}