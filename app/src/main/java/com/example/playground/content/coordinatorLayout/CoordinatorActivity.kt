package com.example.playground.content.coordinatorLayout

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.R
import com.example.playground.databinding.ActivityCoordinatorBinding
import com.google.android.material.appbar.AppBarLayout

class CoordinatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoordinatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.appBar.addOnOffsetChangedListener (object : AppBarStateChangeListener() {
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                super.onOffsetChanged(appBarLayout, verticalOffset)
            }

            override fun onStateChanged(appBarLayout: AppBarLayout, state: State) {
                println("!!! state : $state !!!")
            }

            override fun onPercentageChanged(percentage: Float) {
                println("!!! percentage : $percentage !!!")
            }
        })
    }
}