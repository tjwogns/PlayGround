package com.example.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
        }
    }
}