package com.example.playground.content.til

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RepeatOnLifecycleTestActivity: ComponentActivity() {
    private val stringFlow: Flow<String> = flow {
        for (i in 0..1000){
            emit("integer: $i")
            delay(1000L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                stringFlow.collect {
                    println(it)
                }
            }
        }
    }
}