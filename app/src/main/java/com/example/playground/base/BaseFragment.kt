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
): Fragment() {

    private var _binding: T? = null
    protected val binding
        get() = _binding!!

    protected abstract val viewModel: V
    // Fragment 에 ViewModel 이 필요 없을 수도 있음. 고려 해봐야함.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initView()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}