package com.example.playground.content.dataStore

import android.os.Bundle
import android.widget.TextView
import androidx.core.text.toSpanned
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
        // Preferences DataStore
        binding.tvPrintBoolean.setOnClickListener {
            println("!!! DEBUG Preferences[IS_BOOLEAN_KEY] value is [${viewModel.booleanData.value}] !!!")
        }

        binding.tvSetFalse.setOnClickListener {
            viewModel.setIsBoolean(false)
        }

        binding.tvSetTrue.setOnClickListener {
            viewModel.setIsBoolean(true)
        }


        // Proto DataStore
        binding.tvPrintProtoData.setOnClickListener {
            println("!!! DEBUG Proto ExampleInfo value is name : [${viewModel.protoInfoData.value?.name}], number : [${viewModel.protoInfoData.value?.number}] !!!")
        }
        binding.tvSetProtoData.setOnClickListener {
            viewModel.setExampleInfo(
                name = binding.etName.text.toString(),
                number = binding.etNumber.text.toString().toInt()
            )
        }
    }

    private fun subscribeLiveData() {
        viewModel.booleanData.observe(this) { value ->

        }

        viewModel.protoInfoData.observe(this) {
            binding.etName.setText(it.name, TextView.BufferType.NORMAL)
            binding.etNumber.setText(it.number.toString(), TextView.BufferType.NORMAL)
        }
    }
}