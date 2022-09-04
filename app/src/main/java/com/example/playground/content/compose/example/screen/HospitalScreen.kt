@file:OptIn(ExperimentalMaterialApi::class)

package com.example.playground.content.compose.example.screen

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playground.content.compose.example.ComposeToyViewModel
import com.example.playground.dto.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.round

@ExperimentalMaterialApi
@Composable
fun HospitalScreen(context: Context, data: State<HospitalResult>) {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    val itemState: MutableState<HospitalRowDto> = remember {
        mutableStateOf(HospitalRowDto())
    }

    Hospitals(sheetState = modalBottomSheetState, itemState= itemState, hospitals = data.value)
    HospitalBottomSheet(sheetState = modalBottomSheetState, item = itemState.value)
}


@Composable
fun Hospitals(
    sheetState: ModalBottomSheetState,
    itemState: MutableState<HospitalRowDto>,
    hospitals: HospitalResult
) {
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(items = hospitals.row ?: listOf()) { hospital ->
            HospitalCard(sheetState = sheetState, itemState = itemState, item = hospital)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HospitalCard(
    sheetState: ModalBottomSheetState,
    itemState: MutableState<HospitalRowDto>,
    item: HospitalRowDto
) {

    val coroutineScope = rememberCoroutineScope()
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        onClick = {
            coroutineScope.launch {
                itemState.value = item
                sheetState.show()
            }

        }
    ) {
         Column(
             modifier = Modifier
                 .padding(12.dp)
         ) {
            Text(text = "시군 코드 : ${item.sicunCode}")
            Text(text = "시군 명 : ${item.sicunName}")
            Text(text = "사업장 명 : ${item.workplaceName}")

         }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HospitalBottomSheet(
    sheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    item: HospitalRowDto
) {
    val scrollState = rememberScrollState()

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp * 0.7

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp),
        sheetContent = {

            Column(
                Modifier
                    .height(screenHeight.dp)
                    .verticalScroll(scrollState)
            ) {
//                HospitalDetailCard("인허가일자", item.licenseDate ?: "")
//                HospitalDetailCard("영업상태구분코드", item.businessStateCode ?: "")
                HospitalDetailCard("영업상태명", item.businessStateName ?: "")
                HospitalDetailCard("소재지 전화번호", item.localFactoryTelNumber ?: "")
                HospitalDetailCard("소재지 면적정보", item.localAreaInfo ?: "")
                HospitalDetailCard("소재지 우편번호", item.localZipCode ?: "")
                HospitalDetailCard("도로명 우편번호", item.roadNameZipCode ?: "")
                HospitalDetailCard("도로명 주소", item.refineRoadNameAddress ?: "")
                HospitalDetailCard("지번 주소", item.refineLocalAddress ?: "")
                HospitalDetailCard("우편 번호", item.refineZipCode ?: "")
                HospitalDetailCard("WGS84 위도", item.latitude ?: "")
                HospitalDetailCard("WGS84 경도", item.longitude ?: "")
                HospitalDetailCard("X 좌표값", item.xCoordinate ?: "")
                HospitalDetailCard("Y 좌표값", item.yCoordinate ?: "")
//                HospitalDetailCard("총 종업원 수", item.totalEmployeeCount ?: "")
            }
        }
    ) {
    }

}

@Preview
@Composable
fun Playground() {
    HospitalDetailCard("Key", "Value")
}

@Composable
fun HospitalDetailCard(key: String, value: String) {
    Card(backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()) {
        Row(modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .background(MaterialTheme.colors.primary, RoundedCornerShape(4.dp))
                    .weight(3f)
                    .padding(4.dp)
                ,
                text = key,
                textAlign = TextAlign.Center,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(5f)
                    .background(MaterialTheme.colors.primary, RoundedCornerShape(4.dp))
                    .padding(4.dp),
                text = value,
                color = Color.White
            )
        }
    }
}