package com.example.playground.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tjwogns.presentation.base.BaseViewModel

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
): AppCompatActivity(layoutResId) {

    protected lateinit var binding : T
        private set

    protected abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

    }
}