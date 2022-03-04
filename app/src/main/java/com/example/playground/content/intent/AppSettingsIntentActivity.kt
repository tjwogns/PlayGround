package com.example.playground.content.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityAppSettingsIntentBinding
import com.example.playground.databinding.ActivityDataStoreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AppSettingsIntentActivity : BaseActivity<ActivityAppSettingsIntentBinding, AppSettingsIntentViewModel>(
    R.layout.activity_app_settings_intent
) {

    override val viewModel: AppSettingsIntentViewModel by viewModel()


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
    }

    private fun subscribeLiveData() {

    }
}