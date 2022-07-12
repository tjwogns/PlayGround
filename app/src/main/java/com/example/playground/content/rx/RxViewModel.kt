package com.example.playground.content.rx

import com.example.playground.dto.KaraokeDto
import com.example.playground.retrofit.KaraokeApi
import com.example.playground.retrofit.RetrofitClient
import com.tjwogns.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Single

class RxViewModel: BaseViewModel() {

    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

    fun getKaraokeIndex(brand: String): Single<KaraokeDto> {
        return karaokeApi.getIndex(brand)
    }
}