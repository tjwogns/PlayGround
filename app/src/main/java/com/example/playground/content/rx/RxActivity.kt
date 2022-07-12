package com.example.playground.content.rx

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityRxBinding
import io.reactivex.Observable
import io.reactivex.functions.Consumer
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