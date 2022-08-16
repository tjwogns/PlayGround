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

    private var dialog: DialogBlankFragment? = null

    override fun initView() {
        /**
         * Fragment -> Another Fragment
         */
        binding.btnAction1.setOnClickListener {
            val action = BlankFragmentDirections.actionFraMainBlankToFraSubBlank("Hello~ I'm Here!!!")
            findNavController().navigate(action)
        }

        /**
         * Dialog -> 다른 Destination
         */
        binding.btnAction2.setOnClickListener {
            dialog = DialogBlankFragment(::moveToSubFromDialog)
            dialog?.show(requireActivity().supportFragmentManager, "Fragment")
        }

        /**
         * Fragment -> 다른 Navigation
         */
        binding.btnAction3.setOnClickListener {
            val action = BlankFragmentDirections.actionMainToB()
            findNavController().navigate(action)
        }

    }

    /**
     * 다이어로그로 Action을 보내서 처리하는 방법.
     */
    private fun moveToSubFromDialog() {
        dialog?.dismiss()
        dialog = null

        val action = BlankFragmentDirections.actionDialogToSub("from Blank Dialog !!!")
        findNavController().navigate(action)
    }

}