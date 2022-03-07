package com.example.playground.content.intent

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.Settings
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityIntentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File


class IntentActivity : BaseActivity<ActivityIntentBinding, IntentViewModel>(
    R.layout.activity_intent
) {

    override val viewModel: IntentViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListener()
        subscribeLiveData()
    }

    private fun setListener() {
        // Preferences DataStore
        binding.tvAppSettings.setOnClickListener {
            val intent = Intent().also { intent ->
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                intent.data = Uri.parse("package:$packageName")
            }

            startActivity(intent)
        }

        binding.tvOpenDownloadFolder.setOnClickListener {
            openSpecificFolder()
        }
    }

    private fun subscribeLiveData() {

    }

    fun openDownloadFolder() {
        val intent = Intent(DownloadManager.ACTION_VIEW_DOWNLOADS)

        startActivity(intent)
    }

    private fun openSpecificFolder() {
        val uri = Uri.parse("${Environment.getExternalStorageDirectory()}${File.separator}Download${File.separator}test")
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            data = uri
        }

        startActivity(intent)
    }

    private fun openSpecificFolder2() {
        val uri = Uri.parse("${Environment.getExternalStorageDirectory()}${File.separator}Download${File.separator}test")

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "*/*")
        }
        startActivity(intent)
    }
}