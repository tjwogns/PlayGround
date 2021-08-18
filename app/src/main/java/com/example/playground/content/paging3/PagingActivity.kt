package com.example.playground.content.paging3

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityLocaleBinding
import com.example.playground.databinding.ActivityPagingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PagingActivity : BaseActivity<ActivityPagingBinding, PagingViewModel>(
    R.layout.activity_paging
) {

    override val viewModel: PagingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClickListener()
    }

    private fun setClickListener() {
        binding.tvCreateByBuilder.setOnClickListener {
        }
    }
}