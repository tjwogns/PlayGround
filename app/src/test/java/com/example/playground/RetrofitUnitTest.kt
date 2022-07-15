package com.example.playground

import com.example.playground.retrofit.RetrofitClient
import org.junit.Test

class RetrofitUnitTest {
    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

    @Test
    fun indexTest(){
        karaokeApi.getIndexWithRx("tj")
            .test()
            .assertNoErrors()
            .assertSubscribed()
            .dispose()
    }
}