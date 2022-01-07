package com.example.playground.content.print

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityPrintBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PrintActivity : BaseActivity<ActivityPrintBinding, PrintViewModel>(
    R.layout.activity_print
) {

    override val viewModel: PrintViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setListener() {
        binding.tvPrint1.setOnClickListener {
            printTest01()
        }
    }

    private fun printTest01() {
        val str = "abcdefg"
        val strSubstring = str.substring(6, 10)
        val strTake = str.take(5)

        println("!!! strSubstring : $strSubstring !!!")
        println("!!! strTake : $strTake !!!")
    }

    companion object {
    }
}