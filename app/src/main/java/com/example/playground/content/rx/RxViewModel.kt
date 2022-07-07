package com.example.playground.content.rx

import com.tjwogns.presentation.base.BaseViewModel
import io.reactivex.Observable

class RxViewModel: BaseViewModel() {

    val observable: Observable<Int> = Observable.create(){}
//    {
//        it.onNext(1)
//        it.onNext(2)
//        it.onNext(3)
//    }
}