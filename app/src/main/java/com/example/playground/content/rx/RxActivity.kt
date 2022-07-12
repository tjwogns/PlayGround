package com.example.playground.content.rx

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityRxBinding
import io.reactivex.Observable
import io.reactivex.Scheduler
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