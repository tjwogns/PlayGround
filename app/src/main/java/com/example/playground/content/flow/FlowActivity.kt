package com.example.playground.content.flow

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityFlowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class FlowActivity : BaseActivity<ActivityFlowBinding, FlowViewModel>(
    R.layout.activity_flow
) {

    override val viewModel: FlowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClickListener()
    }

    private fun setClickListener() {
        binding.tvGetBaseFlow.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getBaseFlow()
            }
        }
    }
}