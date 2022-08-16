package com.example.playground.content.navigation

import androidx.navigation.fragment.findNavController
import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentBBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BFragment : BaseFragment<FragmentBBinding, BlankViewModel>(
    R.layout.fragment_b
) {
    override val viewModel: BlankViewModel by viewModel()


    override fun initView() {

        binding.btnAction1.setOnClickListener {
            val action = BFragmentDirections.actionBToB2("Hello~ From.BFragment")
            findNavController().navigate(action)
        }

    }
}