package com.example.playground.content.rx

import com.example.playground.dto.KaraokeDto
import com.example.playground.retrofit.RetrofitClient
import com.tjwogns.presentation.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observables.ConnectableObservable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit

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

    val coldObservable: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS)

    val hotObservable: ConnectableObservable<Long> = Observable.interval(1, TimeUnit.SECONDS).publish()

    val asyncSubject = AsyncSubject.create<String>()
    val behaviorSubject = BehaviorSubject.createDefault("default Value")
    val publisherSubject = PublishSubject.create<String>()
    val replaySubject = ReplaySubject.create<String>()

    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

    fun getKaraokeIndexWithRx(brand: String): Single<List<KaraokeDto>> {
        return karaokeApi.getIndexWithRx(brand).map {
            println("!!! Call API thread, ${Thread.currentThread().name}!!!")
            it
        }
    }


}