package com.example.playground.content.coroutine

import android.os.Bundle
import com.example.playground.R
import com.example.playground.databinding.ActivityCoroutineBinding
import com.example.playground.base.BaseActivity
import com.example.playground.repeatOnStarted
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class CoroutineActivity : BaseActivity<ActivityCoroutineBinding, CoroutineViewModel>(
    R.layout.activity_coroutine
) {

    override val viewModel: CoroutineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClickListener()

        subscribeEvent()
    }

    private fun setClickListener() {
        binding.tvDispatchers.setOnClickListener {
            viewModel.dispatchers()
        }

        binding.tvEx1.setOnClickListener {
            viewModel.ex1()
        }

        binding.tvEx2.setOnClickListener {
            viewModel.ex2()
        }

        binding.tvEx3.setOnClickListener {
            viewModel.ex3()
        }

        binding.tvEx4.setOnClickListener {
            viewModel.ex4()
        }

        binding.tvEx5.setOnClickListener {
            viewModel.ex5()
        }

        binding.tvEx6.setOnClickListener {
            viewModel.ex6()
        }

        binding.tvKaraokeIndexKumyoung.setOnClickListener {
            viewModel.getKaraokeIndexWithFlow("kumyoung")
        }
    }

    private fun subscribeEvent() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: CoroutineViewModel.Event) = when (event) {
        is CoroutineViewModel.Event.Index -> {
            event.index.forEach {
                println("!!! $it !!!")
            }
        }
    }
}