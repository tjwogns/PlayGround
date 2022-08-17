package com.example.playground.content.navigation

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentBlank2Binding
import com.example.playground.databinding.FragmentTransactionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionFragment : BaseFragment<FragmentTransactionBinding, BlankViewModel>(
    R.layout.fragment_transaction
) {
    override val viewModel: BlankViewModel by viewModel()

    //    val args: BlankFragment2Args by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(R.transition.change_bounds)
    }

    override fun initView() {

    }


}