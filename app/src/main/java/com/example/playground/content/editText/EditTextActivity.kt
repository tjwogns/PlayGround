package com.example.playground.content.editText

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityEditTextBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditTextActivity : BaseActivity<ActivityEditTextBinding, EditTextViewModel>(
    R.layout.activity_edit_text
) {

    override val viewModel: EditTextViewModel by viewModel()

    lateinit var inputConnection: InputConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inputConnection = binding.etEx.onCreateInputConnection(EditorInfo())
        binding.etEx.requestFocus()
        setListener()

    }


    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
        binding.btnInput0.setOnClickListener {
            commitText("0")
            binding.etEx.requestFocus()
        }

        binding.btnInput1.setOnClickListener {
            commitText("1")
            binding.etEx.requestFocus()
        }

    }

    private fun commitText(input: String) {
        inputConnection.commitText(input, 1)
    }

    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {

    }

    companion object {
    }
}