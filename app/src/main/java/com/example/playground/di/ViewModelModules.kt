package com.example.playground.di

import com.example.playground.content.coroutine.CoroutineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CoroutineViewModel() }
}