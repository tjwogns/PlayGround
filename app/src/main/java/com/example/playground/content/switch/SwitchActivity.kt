package com.example.playground.content.switch

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityNotificationBinding
import com.example.playground.databinding.ActivitySwitchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SwitchActivity : BaseActivity<ActivitySwitchBinding, SwitchViewModel>(
    R.layout.activity_switch
) {

    override val viewModel: SwitchViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.tvSwitch3.setOnTouchListener { _, event ->
            event.actionMasked == MotionEvent.ACTION_MOVE
        }
    }
    companion object {
    }
}