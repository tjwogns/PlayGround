package com.example.playground.di

import com.example.playground.content.activityFlag.ActivityFlagViewModel
import com.example.playground.content.coroutine.CoroutineViewModel
import com.example.playground.content.dataStore.DataStoreViewModel
import com.example.playground.content.deeplink.DeepLinkViewModel
import com.example.playground.content.issue.IssueViewModel
import com.example.playground.content.locale.LocaleViewModel
import com.example.playground.content.mediaStore.MediaStoreViewModel
import com.example.playground.content.notification.NotificationViewModel
import com.example.playground.content.paging3.PagingViewModel
import com.example.playground.content.print.PrintViewModel
import com.example.playground.content.sso.SsoViewModel
import com.example.playground.content.switch.SwitchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CoroutineViewModel() }
    viewModel { LocaleViewModel() }
    viewModel { PagingViewModel() }
    viewModel { DeepLinkViewModel() }
    viewModel { IssueViewModel() }
    viewModel { NotificationViewModel() }
    viewModel { SwitchViewModel() }
    viewModel { PrintViewModel() }
    viewModel { MediaStoreViewModel() }
    viewModel { ActivityFlagViewModel() }
    viewModel { DataStoreViewModel() }
    viewModel { SsoViewModel() }
}