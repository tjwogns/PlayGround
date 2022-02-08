package com.example.playground.content.mediaStore

import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.tvPath.setOnClickListener {
                println("!!! MediaStore.Downloads.EXTERNAL_CONTENT_URI : [${MediaStore.Downloads.EXTERNAL_CONTENT_URI}] !!!")
                println("!!! MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : [${MediaStore.Audio.Media.EXTERNAL_CONTENT_URI}] !!!")
                println("!!! MediaStore.Images.Media.EXTERNAL_CONTENT_URI : [${MediaStore.Images.Media.EXTERNAL_CONTENT_URI}] !!!")
                println("!!! MediaStore.Video.Media.EXTERNAL_CONTENT_URI : [${MediaStore.Video.Media.EXTERNAL_CONTENT_URI}] !!!")
            }
        }
    }

    companion object {
    }
}