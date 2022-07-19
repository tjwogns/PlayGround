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
import com.example.playground.content.activityFlag.ActivityFlagActivity
import com.example.playground.content.algorithm.AlgorithmActivity
import com.example.playground.content.compose.Compose1Activity
import com.example.playground.content.dataStore.DataStoreActivity
import com.example.playground.content.editText.EditTextActivity
import com.example.playground.content.fileDirectory.FileDirectoryActivity
import com.example.playground.content.flow.FlowActivity
import com.example.playground.content.intent.IntentActivity
import com.example.playground.content.mediaStore.MediaStoreActivity
import com.example.playground.content.notification.NotificationActivity
import com.example.playground.content.print.PrintActivity
import com.example.playground.content.rx.RxActivity
import com.example.playground.content.switch.SwitchActivity
import com.example.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListener()

    }

    private fun setListener() {
        binding.tvAlgorithm.setOnClickListener { view ->
            startIntentActivity("Algorithm", AlgorithmActivity::class.java)
        }

        binding.tvCompose.setOnClickListener { view ->
            startIntentActivity("Compose", ComposeActivity::class.java)
        }

        binding.tvCompose1.setOnClickListener { view ->
            startIntentActivity("Compose1", Compose1Activity::class.java)
        }

        binding.tvAnimate.setOnClickListener { view ->
            startIntentActivity("Animate", AnimationActivity::class.java)
        }

        binding.tvActivityResult.setOnClickListener { view ->
            startIntentActivity("ActivityResult", ActivityResultActivity::class.java)
        }

        binding.tvCoordinator.setOnClickListener { view ->
            startIntentActivity("Coordinator", CoordinatorActivity::class.java)
        }

        binding.tvCoroutine.setOnClickListener { view ->
            startIntentActivity("Coroutine", CoroutineActivity::class.java)
        }

        binding.tvLocale.setOnClickListener { view ->
            startIntentActivity("Locale", LocaleActivity::class.java)
        }

        binding.tvFlow.setOnClickListener { view ->
            startIntentActivity("Flow", FlowActivity::class.java)
        }

        binding.tvDeepLink.setOnClickListener { view ->
            startIntentActivity("DeepLink", DeepLinkActivity::class.java)
        }

        binding.tvIssue.setOnClickListener { view ->
            startIntentActivity("Issue", IssueActivity::class.java)
        }

        binding.tvNotification.setOnClickListener { view ->
            startIntentActivity("Notification", NotificationActivity::class.java)
        }

        binding.tvSwitch.setOnClickListener { view ->
            startIntentActivity("View Switch", SwitchActivity::class.java)
        }

        binding.tvPrint.setOnClickListener { view ->
            startIntentActivity("Print Test", PrintActivity::class.java)
        }

        binding.tvMediaStore.setOnClickListener { view ->
            startIntentActivity("Media Store Test", MediaStoreActivity::class.java)
        }

        binding.tvStartActivityFlag.setOnClickListener { view ->
            startIntentActivity("Start Activity Flag Test", ActivityFlagActivity::class.java)
        }

        binding.tvDataStore.setOnClickListener { view ->
            startIntentActivity("DataStore Test", DataStoreActivity::class.java)
        }

        binding.tvSsoTest.setOnClickListener { view ->
        }

        binding.tvIntentTest.setOnClickListener { view ->
            startIntentActivity("Intent Test", IntentActivity::class.java)
        }

        binding.tvFileDirectoryTest.setOnClickListener { view ->
            startIntentActivity("File Directory Test", FileDirectoryActivity::class.java)
        }

        binding.tvRx.setOnClickListener { view ->
            startIntentActivity("RxJava Test", RxActivity::class.java)
        }

        binding.tvEditTextTest.setOnClickListener { view ->
            startIntentActivity("EditText Test", EditTextActivity::class.java)
        }
    }

    private fun startIntentActivity(tag: String, activity: Class<*>) {
        Toast.makeText(this, tag, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}