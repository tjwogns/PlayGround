package com.example.playground.content.rx

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityRxBinding
import io.reactivex.Observable
import org.koin.androidx.viewmodel.ext.android.viewModel

class RxActivity : BaseActivity<ActivityRxBinding, RxViewModel>(
    R.layout.activity_rx
) {

    override val viewModel: RxViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.tvEx1.setOnClickListener {
            Observable
                .just("Hello?", "RxJava!?")
                .map { it.dropLast(1) }
                .subscribe { println(it) }
        }
    }

    companion object {
    }
}