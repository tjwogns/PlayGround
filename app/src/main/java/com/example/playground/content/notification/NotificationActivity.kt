package com.example.playground.content.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.ACTION_UP
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityNotificationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NotificationActivity : BaseActivity<ActivityNotificationBinding, NotificationViewModel>(
    R.layout.activity_notification
) {

    override val viewModel: NotificationViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val notificationManager = baseContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        makeNotifyChannel(notificationManager)

        setListener()
    }

    private fun setListener() {
        binding.tvSend.setOnClickListener {
            makeNoti()
        }
    }


    private fun makeNoti() {
        val SUMMARY_ID = 0
        val GROUP_KEY_WORK_EMAIL = "com.android.example.WORK_EMAIL"

        val messageID = (1..100).random()
        val newMessageNotification1 = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_compose_image)
            .setContentTitle("Notification TEST $messageID")
            .setContentText("You will not believe...")
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .build()

        val summaryNotification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Message Surmmary")
            //set content text to support devices running API level < 24
            .setContentText("Two new messages")
            .setSmallIcon(R.drawable.ic_summary)
            //build summary info into InboxStyle template
            //specify which group this notification belongs to
            .setGroup(GROUP_KEY_WORK_EMAIL)
            //set this notification as the summary for the group
            .setGroupSummary(true)
            .build()

        NotificationManagerCompat.from(this).apply {
            println("!!! DEBUG !!!")
            notify(messageID, newMessageNotification1)
            notify(SUMMARY_ID, summaryNotification)
        }

    }

    fun makeNotifyChannel(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                "Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.setShowBadge(true)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    companion object {
        const val CHANNEL_ID = "NotificationTest"
    }
}