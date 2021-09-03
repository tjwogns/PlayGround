package com.example.playground.content.deeplink

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityDeepLinkBinding
import com.example.playground.databinding.ActivityFlowBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DeepLinkActivity : BaseActivity<ActivityDeepLinkBinding, DeepLinkViewModel>(
    R.layout.activity_deep_link
) {

    override val viewModel: DeepLinkViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setClickListener()
    }

    private fun setClickListener() {
        binding.tvEx1.setOnClickListener {
        }
        binding.tvEx2.setOnClickListener {
        }
        binding.tvEx3.setOnClickListener {
        }
        binding.tvEx4.setOnClickListener {
        }
        binding.tvEx5.setOnClickListener {
        }
        binding.tvEx6.setOnClickListener {
        }
    }
}