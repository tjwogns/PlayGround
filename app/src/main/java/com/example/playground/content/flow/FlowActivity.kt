package com.example.playground.content.flow

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.content.deeplink.DeepLinkViewModel
import com.example.playground.databinding.ActivityFlowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FlowActivity : BaseActivity<ActivityFlowBinding, FlowViewModel>(
    R.layout.activity_flow
) {

    override val viewModel: FlowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribe()

        setClickListener()
    }

    private fun setClickListener() {
        binding.tvGetBaseFlow.setOnClickListener {
//            CoroutineScope(Dispatchers.Main).launch {
//                viewModel.getBaseFlow().collect { value ->
//                    println("!!! value [$value] !!!!")
//                }
//            CoroutineScope(Dispatchers.Main).launch {
//                launch {
//                    println("!!! started collect 1 !!!")
//                    viewModel.stateInFlow.collect {
//                        println("!!! collect 1 : $it !!!")
//                    }
//                }
//
//                delay(3000)
//                launch {
//                    println("!!! started collect 2 !!!")
//                    viewModel.stateInFlow.collect {
//                        println("!!! collect 2 : $it !!!")
//                    }
//                }
//            }

            CoroutineScope(Dispatchers.Main).launch {
                viewModel.getBaseFlow().conflate().collect {
                    delay(500)
                    println("!!! collect value : $it !!!")
                }
            }
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
            viewModel.flowsAreCold()
        }
        binding.tvEx6.setOnClickListener {
            viewModel.ex6()
        }

        binding.tvKaraokeFlow.setOnClickListener {
//            lifecycleScope.launch {
//                viewModel.getKaraokeFlow("kumyoung").collect {
//                    println("!!! $it !!!")
//                }
//            }
            viewModel.getKaraokeFlow2("kumyoung")
        }
    }

    private fun subscribe() {
        lifecycleScope.launch {
            viewModel.karaokeStateFlow.collect { result ->
                println("!!! Success !!!")
                println("!!! Size ${result.size} !!!")
                result.forEach {
                    CoroutineScope(Dispatchers.Main).launch {
                        println("!!! $it !!!")
                    }
                }
            }
        }
    }
}