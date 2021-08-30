package com.example.playground.content.flow

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityFlowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getBaseFlow()
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
    }

    private fun subscribe() {
        viewModel.baseData.observe(this) {

        }
    }
}