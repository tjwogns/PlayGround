package com.example.playground.content.rx

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityRxBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

class RxActivity : BaseActivity<ActivityRxBinding, RxViewModel>(
    R.layout.activity_rx
) {

    override val viewModel: RxViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()

//        subscribeObservable()
    }


    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
        binding.tvEx1.setOnClickListener {
            Observable
                .just("Hello?", "RxJava!?")
                .map { it.dropLast(1) }
                .subscribe (::println)

        }

        binding.tvObservableCreateOnSubscribe.setOnClickListener {
            viewModel.observableCreate
                .doOnNext {
                    println("!!! DEBUG Create doOnNext $it !!!")
                }
                .subscribe({
                    println("!!! DEBUG Create arg1 $it !!!")
                }, {
                    println("!!! DEBUG Create arg2 $it !!!")
                }, {
                    println("!!! DEBUG Create arg3  !!!")
                })
//                {
//                    println("!!! DEBUG Create subscribe $it !!!")
//                }
        }

        binding.tvObservableJust.setOnClickListener {
            viewModel.observableJust.subscribe({

            },{

            }, {

            })
        }

        binding.tvKaraokeIndexKumyoung.setOnClickListener {
            viewModel.getKaraokeIndexWithRx("kumyoung")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSuccess {
                    println("!!! First Success thread, ${Thread.currentThread().name}!!!")
                }
                .doOnError {
                    println("!!! Call Failed  !!!")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    println("!!! Second Success thread, ${Thread.currentThread().name}!!!")
                }
                .observeOn(Schedulers.io())
                .subscribe({
                    println("!!! Third thread, ${Thread.currentThread().name}!!!")
                    println("!!! Size ${it.size} !!!")
                    it.forEach { item ->
                        println("$item")
                    }
                },{
                    println("!!! ${it.printStackTrace()} !!!")
                })
        }

        binding.tvKaraokeIndexTj.setOnClickListener {
            viewModel.getKaraokeIndexWithRx("tj")
                .doOnSuccess {
                    println("!!! Call Success !!!")
                }
                .doOnError {
                    println("!!! Call Failed  !!!")
                }
                .subscribeOn(Schedulers.io())
                .subscribe({
                    println("!!! Size ${it.size} !!!")
                    it.forEach { item ->
                        println("$item")
                    }
                },{
                    println("!!! ${it.printStackTrace()} !!!")
                })
        }

        binding.tvObservableCold1.setOnClickListener {
            viewModel.coldObservable.subscribe { value -> println("First value : $value") }
        }

        binding.tvObservableCold2.setOnClickListener {
            viewModel.coldObservable.subscribe { value -> println("Second value : $value") }
        }

        binding.tvObservableHot1.setOnClickListener {
            viewModel.hotObservable.connect()
            viewModel.hotObservable.subscribe { value -> println("First value : $value") }
        }

        binding.tvObservableHot2.setOnClickListener {
            viewModel.hotObservable.subscribe { value -> println("Second value : $value") }
        }

        binding.tvObservableAsyncSubject.setOnClickListener {
            viewModel.asyncSubject.subscribe { println("!!! First subscriber $it !!!") }
            viewModel.asyncSubject.onNext("Tom")
            viewModel.asyncSubject.onNext("Jerry")
            viewModel.asyncSubject.onComplete()
            viewModel.asyncSubject.subscribe { println("!!! Second subscriber $it !!!") }
            viewModel.asyncSubject.onNext("Darong")
        }

        binding.tvObservableBehaviorSubject.setOnClickListener {
            viewModel.behaviorSubject.subscribe { println("!!! First subscriber $it !!!") }
            viewModel.behaviorSubject.onNext("Tom")
            viewModel.behaviorSubject.onNext("Jerry")
            viewModel.behaviorSubject.subscribe { println("!!! Second subscriber $it !!!") }
            viewModel.behaviorSubject.onNext("Darong")
            viewModel.behaviorSubject.onComplete()
        }

        binding.tvObservablePublisherSubject.setOnClickListener {
            viewModel.publisherSubject.subscribe { println("!!! First subscriber $it !!!") }
            viewModel.publisherSubject.onNext("Tom")
            viewModel.publisherSubject.onNext("Jerry")
            viewModel.publisherSubject.subscribe { println("!!! Second subscriber $it !!!") }
            viewModel.publisherSubject.onNext("Darong")
            viewModel.publisherSubject.onComplete()
        }

        binding.tvObservableReplaySubject.setOnClickListener {
            viewModel.replaySubject.subscribe { println("!!! First subscriber $it !!!") }
            viewModel.replaySubject.onNext("Tom")
            viewModel.replaySubject.onNext("Jerry")
            viewModel.replaySubject.subscribe { println("!!! Second subscriber $it !!!") }
            viewModel.replaySubject.onNext("Darong")
            viewModel.replaySubject.onComplete()
        }

        binding.tvObservableDebugComplete.setOnClickListener {
            Observable.just(10, 5, 0)
                .doOnNext{ data ->
                    Log.d("onNext()", data.toString())
                }
                .doOnComplete {
                    Log.d("onComplete()", "Logging complete!!!")
                }
                .doOnError { error ->
                    Log.e("onError", error.message ?: "")
                }
                .subscribe {
                    Log.d("subscribe", "Logging subscribe $it !!!")
                }
        }

        binding.tvObservableDebugError.setOnClickListener {
            Observable.just(10, 5, 0)
                .map { value -> 10 / value }
                .doOnNext{ data ->
                    Log.d("onNext()", data.toString())
                }
                .doOnComplete {
                    Log.d("onComplete()", "Logging complete!!!")
                }
                .doOnError { error ->
                    Log.e("onError", error.message ?: "")
                }
                .subscribe {
                    Log.d("subscribe", "Logging subscribe $it !!!")
                }
        }

        binding.tvObservableError.setOnClickListener {
            val numbers = listOf("10", "20", "a", "30")
            Observable.fromIterable(numbers)
                .map { data -> Integer.parseInt(data) }
                .onErrorReturn { e ->
                    e.printStackTrace()
                    -1
                }
                .subscribe {
                    println("!!! result: $it !!!")
                }
        }
    }

    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {
        viewModel.observableCreate.subscribe {
            println("$it")
        }
    }

    companion object {
    }
}