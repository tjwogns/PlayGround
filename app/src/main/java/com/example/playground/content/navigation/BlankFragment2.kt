package com.example.playground.content.navigation

import androidx.fragment.app.Fragment
import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentBlank2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : BaseFragment<FragmentBlank2Binding, BlankViewModel>(
    R.layout.fragment_blank2
) {
    override val viewModel: BlankViewModel by viewModel()

    override fun initView() {
    }


}