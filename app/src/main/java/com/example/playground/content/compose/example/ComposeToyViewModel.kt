package com.example.playground.content.compose.example

import com.example.playground.dto.KaraokeDto
import com.example.playground.retrofit.RetrofitClient
import com.tjwogns.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ComposeToyViewModel: BaseViewModel() {


    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

//    val singInfo: Flow<List<KaraokeDto>> = emptyFlow()

    fun getSingInfo(): Flow<List<KaraokeDto>> = flow {
//        viewModelScope.launch {
//            CoroutineScope(Dispatchers.IO).launch {
                val data = karaokeApi.getIndexWithFlow2("kumyoung")
                emit(data)
//            }
//        }
    }

}