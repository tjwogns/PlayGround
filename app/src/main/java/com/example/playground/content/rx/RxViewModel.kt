package com.example.playground.content.rx

import com.example.playground.dto.KaraokeDto
import com.example.playground.retrofit.KaraokeApi
import com.example.playground.retrofit.RetrofitClient
import com.tjwogns.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Single

class RxViewModel: BaseViewModel() {

    val observableCreate: Observable<Int> = Observable.create {
        it.onNext(1)
        it.onNext(2)
        it.onNext(3)
        it.onComplete()
        it.onNext(4)
//        it.onError(throw Exception())
//        it.onComplete()
    }

    val observableJust: Observable<String> = Observable.just("a","b","c", "d", "e")

    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

    fun getKaraokeIndex(brand: String): Single<List<KaraokeDto>> {
        return karaokeApi.getIndex(brand)
    }
}