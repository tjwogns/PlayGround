package com.example.playground.content.issue

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.ACTION_UP
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityIssueBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class IssueActivity : BaseActivity<ActivityIssueBinding, IssueViewModel>(
    R.layout.activity_issue
) {

    override val viewModel: IssueViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    private fun setListener() {
        binding.tietText0.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tietText1.requestFocus()
                printDebugMessage(0, keyCode, event)
            }
            false
        }

        binding.tietText1.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tietText2.requestFocus()
                printDebugMessage(1, keyCode, event)
            }
            false
        }

        binding.tietText2.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tietText3.requestFocus()
                printDebugMessage(2, keyCode, event)
            }
            false
        }

        binding.tietText3.setOnKeyListener { _, keyCode, event ->
            printDebugMessage(3, keyCode, event)
            false
        }

        binding.tietText4.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                binding.tietText5.requestFocus()
                printDebugMessage(4, keyCode, event)
            }
            false
        }

        binding.tietText5.setOnKeyListener { _, keyCode, event ->
            printDebugMessage(5, keyCode, event)
            false
        }

        binding.tietText6.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == ACTION_UP) {
                binding.tietText7.requestFocus()
                printDebugMessage(6, keyCode, event)
            }
            false
        }

        binding.tietText7.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == ACTION_UP) {
                binding.tietText8.requestFocus()
                printDebugMessage(7, keyCode, event)
            }
            false
        }

        binding.tietText8.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == ACTION_UP) {
                binding.tietText9.requestFocus()
                printDebugMessage(8, keyCode, event)
            }
            false
        }

        binding.tietText9.setOnKeyListener { _, keyCode, event ->
            printDebugMessage(9, keyCode, event)
            false
        }
    }

    private fun printDebugMessage(num: Int, keyCode: Int, event: KeyEvent) {
        println("!!! DEBUG Text$num keyCode: $keyCode !!!")
        println("!!! DEBUG Text$num event: $event !!!")
    }
}