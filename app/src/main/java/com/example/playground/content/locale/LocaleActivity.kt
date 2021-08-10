package com.example.playground.content.locale

import android.os.Bundle
import com.example.playground.R
import com.example.playground.databinding.ActivityCoroutineBinding
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityLocaleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocaleActivity : BaseActivity<ActivityLocaleBinding, LocaleViewModel>(
    R.layout.activity_locale
) {

    override val viewModel: LocaleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClickListener()
    }

    private fun setClickListener() {
        binding.tvCreateBuilder.setOnClickListener {
            viewModel.createBuilder()
        }

        binding.tvEx1.setOnClickListener {
            viewModel.ex1()
        }
    }
}