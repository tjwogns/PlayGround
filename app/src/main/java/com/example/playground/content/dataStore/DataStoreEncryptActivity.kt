package com.example.playground.content.dataStore

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityDataStoreEncryptBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataStoreEncryptActivity : BaseActivity<ActivityDataStoreEncryptBinding, DataStoreViewModel>(
    R.layout.activity_data_store_encrypt
) {

    override val viewModel: DataStoreViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListener()
        subscribeLiveData()
    }

    private fun setListener() {

    }

    private fun subscribeLiveData() {
        viewModel.booleanData.observe(this) { value ->

        }

        viewModel.protoInfoData.observe(this) {

        }
    }
}