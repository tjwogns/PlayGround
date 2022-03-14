package com.example.playground.content.intent

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import android.provider.DocumentsContract
import android.provider.Settings
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun openSpecificFolder3() {
        val sm = getSystemService(STORAGE_SERVICE) as StorageManager

        val intent = sm.getPrimaryStorageVolume().createOpenDocumentTreeIntent()
        //String startDir = "Android";
        //String startDir = "Download"; // Not choosable on an Android 11 device
        //String startDir = "DCIM";
        //String startDir = "DCIM/Camera";  // replace "/", "%2F"
        //String startDir = "DCIM%2FCamera";
        //String startDir = "Android";
        //String startDir = "Download"; // Not choosable on an Android 11 device
        //String startDir = "DCIM";
        //String startDir = "DCIM/Camera";  // replace "/", "%2F"
        //String startDir = "DCIM%2FCamera";
//        val startDir = "Documents"
//        val startDir = "Download"
        val startDir = "testFolder"
//        val startDir = "Download%3AtestFolder"

        var uri = intent.getParcelableExtra<Uri>("android.provider.extra.INITIAL_URI")

        var scheme = uri.toString()

        println("!!! scheme: $scheme")
        scheme = scheme.replace("/root/", "/document/")

        scheme += "%3A$startDir"

        uri = Uri.parse(scheme)


        println("!!! uri: $scheme")

        intent.putExtra("android.provider.extra.INITIAL_URI", uri)


//        startActivityForResult(intent, OPEN_DOCUMENT)
    }
}