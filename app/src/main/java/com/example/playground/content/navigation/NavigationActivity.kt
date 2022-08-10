package com.example.playground.content.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityNavigationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : BaseActivity<ActivityNavigationBinding, NavigationViewModel>(
    R.layout.activity_navigation
) {

    override val viewModel: NavigationViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()

    }


    @SuppressLint("ClickableViewAccessibility", "CheckResult")
    private fun setListener() {
    }


    /**
     * 구독
     */
    @SuppressLint("CheckResult")
    private fun subscribeObservable() {

    }

    companion object {
    }
}