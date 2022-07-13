package com.example.playground.content.rx

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityRxBinding
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer
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
            viewModel.getKaraokeIndex("kumyoung")
                .doOnSuccess {
                    println("!!! Call Success !!!")
                }
                .doOnError {
                    println("!!! Call Failed  !!!")
                }
                .subscribeOn(Schedulers.io())
                .subscribe({ it ->
                    println("!!! Size ${it.size} !!!")
                    it.forEach { item ->
                        println("$item")
                    }
                },{
                    println("!!! ${it.printStackTrace()} !!!")
                })
        }

        binding.tvKaraokeIndexTj.setOnClickListener {
            viewModel.getKaraokeIndex("tj")
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