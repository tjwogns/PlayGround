package com.example.playground.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tjwogns.presentation.base.BaseViewModel

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel>(
    @LayoutRes private val layoutResId: Int
): Fragment(layoutResId) {

    protected lateinit var binding : T
        private set

    protected abstract val viewModel: V
    // Fragment에 ViewModel이 필요 없을 수도 있음. 고려 해봐야함.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this@BaseFragment
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initView()
}