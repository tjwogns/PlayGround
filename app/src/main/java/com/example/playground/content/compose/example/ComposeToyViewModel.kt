package com.example.playground.content.compose.example

import androidx.lifecycle.viewModelScope
import com.example.playground.dto.*
import com.example.playground.retrofit.RetrofitClient
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ComposeToyViewModel: BaseViewModel() {


    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }
    private val openApi by lazy {
        RetrofitClient.openApi
    }

//    val singInfo: Flow<List<KaraokeDto>> = emptyFlow()

    fun getSingInfo(): Flow<List<KaraokeDto>> = flow {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val data = karaokeApi.getIndexWithFlow2("kumyoung")
                emit(data)
            }
        }
    }

    fun getHospital(): Flow<HospitalResult> = flow {

//        viewModelScope.launch {
//            CoroutineScope(Dispatchers.IO).launch {
                val data = openApi.getHospital().hospital?.let {
                    val head = HospitalHeadDto(
                        it[0].head?.get(0)?.totalCount,
                        it[0].head?.get(1)?.result,
                        it[0].head?.get(2)?.apiVersion
                    )

                    val row = mutableListOf<HospitalRowDto>()
                    row.addAll(it[1].row?: listOf())

                    val result = HospitalResult(
                        head, row
                    )

                    result
                } ?: HospitalResult()

                emit(data)
//            }
//        }
    }

}