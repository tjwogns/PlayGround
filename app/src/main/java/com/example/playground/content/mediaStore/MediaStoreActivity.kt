package com.example.playground.content.mediaStore

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityMediaStoreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MediaStoreActivity : BaseActivity<ActivityMediaStoreBinding, MediaStoreViewModel>(
    R.layout.activity_media_store
) {

    override val viewModel: MediaStoreViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    private fun setListener() {

    }
    companion object {
    }
}