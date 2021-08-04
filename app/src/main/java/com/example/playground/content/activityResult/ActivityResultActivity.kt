package com.example.playground.content.activityResult

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.example.playground.R
import com.example.playground.databinding.ActivityActivityResultBinding
import com.example.playground.databinding.ActivityAnimateBinding

class ActivityResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_activity_result)

        setListener()
    }

    private fun setListener() {
        binding.btnOpenDocumentTree.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
//            intent.

//            openDocumentTreeLauncher.launch(intent)
        }
    }

    private val openDocumentTreeLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        result.data?.let {
            println("!!! it.data : ${it.data} !!!")
        }
    }


}