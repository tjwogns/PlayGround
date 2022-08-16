package com.example.playground.content.navigation

import androidx.navigation.fragment.navArgs
import com.example.playground.R
import com.example.playground.base.BaseFragment
import com.example.playground.databinding.FragmentDeepLinkBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 딥링크 테스트 명렁어
 * adb shell am start -a android.intent.action.VIEW -d "http://PlayGroundTest/1" com.example.playground
 */
class DeepLinkFragment : BaseFragment<FragmentDeepLinkBinding, BlankViewModel>(
    R.layout.fragment_deep_link
) {
    override val viewModel: BlankViewModel by viewModel()

    val args: DeepLinkFragmentArgs by navArgs()

    override fun initView() {

        val str = args.testStringArg
        binding.tvArg.text = str
        println("!!! DEBUG !!! str = $str")
    }


}