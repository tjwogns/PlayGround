package com.example.playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.playground.activityResult.ActivityResultActivity
import com.example.playground.animate.AnimationActivity
import com.example.playground.compose.ComposeActivity
import com.example.playground.coordinatorLayout.CoordinatorActivity
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
    }
}