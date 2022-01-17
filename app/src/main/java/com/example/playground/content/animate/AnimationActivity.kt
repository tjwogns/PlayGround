package com.example.playground.content.animate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.example.playground.R
import com.example.playground.databinding.ActivityAnimateBinding

class AnimationActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animate)

        // todo animation group  잔상 처리 테스트
        setListener()
    }

    private fun setListener() {
        binding.btnAddView.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        val targetView = View(this)

        val layoutParams = ConstraintLayout.LayoutParams(90, 90)
        val set = ConstraintSet()
        set.clone(binding.clContainer)

        targetView.layoutParams = layoutParams
        targetView.setBackgroundColor(getColor(R.color.black))

        binding.clContainer1.addView(targetView)
    }
}