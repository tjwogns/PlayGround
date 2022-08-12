package com.example.playground.content.navigation

import androidx.navigation.fragment.findNavController
import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentBlankBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BlankFragment : BaseFragment<FragmentBlankBinding, BlankViewModel>(
    R.layout.fragment_blank
) {
    override val viewModel: BlankViewModel by viewModel()

    override fun initView() {
        binding.btnAction1.setOnClickListener {
            val action = BlankFragmentDirections.actionFraMainBlankToFraSubBlank("Hello~ I'm Here!!!")
            findNavController().navigate(action)
        }

    }
}