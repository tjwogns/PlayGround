package com.example.playground.content.deeplink

import android.net.Uri
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

        val action: String? = intent?.action

        val data: Uri? = intent?.data

        action?.let {
            binding.tvActionValue.text = it
        }

        data?.let {
            binding.tvDataValue.text = it.toString()
        }
    }
}