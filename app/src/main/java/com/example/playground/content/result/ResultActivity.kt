package com.example.playground.content.result

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : BaseActivity<ActivityResultBinding, ResultViewModel>(
    R.layout.activity_result
) {

    override val viewModel: ResultViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()

    }


    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
        /**
         */
        binding.btnInput0.setOnClickListener {
        }

        /**
         */
        binding.btnInput1.setOnClickListener {
        }

        binding.btnInput2.setOnClickListener {
        }
    }


    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {

    }

    companion object {
    }
}