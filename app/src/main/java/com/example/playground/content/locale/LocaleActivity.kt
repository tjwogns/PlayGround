package com.example.playground.content.locale

import android.os.Bundle
import com.example.playground.R
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
        binding.tvCreateByBuilder.setOnClickListener {
            viewModel.createByBuilder()
        }

        binding.tvCreateByConstructor.setOnClickListener {
            viewModel.createByConstructor()
        }

        binding.tvCreateByFactory.setOnClickListener {
            viewModel.createByFactoryMethod()
        }

        binding.tvCreateByConstants.setOnClickListener {
            viewModel.createByConstants()
        }

        binding.tvLanguage.setOnClickListener {
            viewModel.getLanguage()
        }

        binding.tvCountry.setOnClickListener {
            viewModel.getCountry()
        }

        binding.tvDefault.setOnClickListener {
            viewModel.getDefault()
        }

        binding.tvDeviceLocale.setOnClickListener {
            viewModel.getDeviceLocale()
        }
    }
}