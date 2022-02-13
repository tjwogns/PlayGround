package com.example.playground.content.dataStore

import android.content.Context
import android.os.Bundle
import com.example.playground.AppBase
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityDataStoreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DataStoreActivity : BaseActivity<ActivityDataStoreBinding, DataStoreViewModel>(
    R.layout.activity_data_store
) {

    override val viewModel: DataStoreViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListener()
        subscribeLiveData()
    }

    private fun setListener() {
        binding.tvPrintBoolean.setOnClickListener {
            println("!!! DEBUG Preferences[IS_BOOLEAN_KEY] value is [${viewModel.booleanData.value}] !!!")
        }

        binding.tvSetFalse.setOnClickListener {
            viewModel.setIsBoolean(false)
        }

        binding.tvSetTrue.setOnClickListener {
            viewModel.setIsBoolean(true)
        }
    }

    private fun subscribeLiveData() {
        viewModel.booleanData.observe(this) { value ->

        }
    }
}