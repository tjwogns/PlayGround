package com.example.playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.playground.content.activityResult.ActivityResultActivity
import com.example.playground.content.animate.AnimationActivity
import com.example.playground.content.compose.ComposeActivity
import com.example.playground.content.coroutine.CoroutineActivity
import com.example.playground.content.coordinatorLayout.CoordinatorActivity
import com.example.playground.content.deeplink.DeepLinkActivity
import com.example.playground.content.issue.IssueActivity
import com.example.playground.content.locale.LocaleActivity
import com.example.playground.content.notification.NotificationActivity
import com.example.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListener()

    }

    private fun setListener() {
        binding.tvCompose.setOnClickListener { view ->
            Toast.makeText(this, "Compose", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ComposeActivity::class.java)
            startActivity(intent)
        }

        binding.tvAnimate.setOnClickListener { view ->
            Toast.makeText(this, "Animate", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnimationActivity::class.java)
            startActivity(intent)
        }

        binding.tvActivityResult.setOnClickListener { view ->
            Toast.makeText(this, "ActivityResult", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ActivityResultActivity::class.java)
            startActivity(intent)
        }

        binding.tvCoordinator.setOnClickListener { view ->
            Toast.makeText(this, "Coordinator", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CoordinatorActivity::class.java)
            startActivity(intent)
        }

        binding.tvCoroutine.setOnClickListener { view ->
            Toast.makeText(this, "Coroutine", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CoroutineActivity::class.java)
            startActivity(intent)
        }

        binding.tvLocale.setOnClickListener { view ->
            Toast.makeText(this, "Locale", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LocaleActivity::class.java)
            startActivity(intent)
        }

        binding.tvFlow.setOnClickListener { view ->
            Toast.makeText(this, "Flow", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DeepLinkActivity::class.java)
            startActivity(intent)
        }

        binding.tvDeepLink.setOnClickListener { view ->
            Toast.makeText(this, "DeepLink", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DeepLinkActivity::class.java)
            startActivity(intent)
        }

        binding.tvIssue.setOnClickListener { view ->
            Toast.makeText(this, "Issue", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, IssueActivity::class.java)
            startActivity(intent)
        }

        binding.tvNotification.setOnClickListener { view ->
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }
}