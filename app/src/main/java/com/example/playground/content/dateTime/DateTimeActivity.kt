package com.example.playground.content.dateTime

import android.net.Uri
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityDateTimeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DateTimeActivity : BaseActivity<ActivityDateTimeBinding, DateTimeViewModel>(
    R.layout.activity_date_time
) {

    override val viewModel: DateTimeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btn0.setOnClickListener {
            viewModel.ex1()
        }
    }
}