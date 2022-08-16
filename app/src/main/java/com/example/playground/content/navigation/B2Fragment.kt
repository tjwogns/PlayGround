package com.example.playground.content.navigation

import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentB2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class B2Fragment : BaseFragment<FragmentB2Binding, BlankViewModel>(
    R.layout.fragment_b2
) {
    override val viewModel: BlankViewModel by viewModel()


    override fun initView() {

    }

}