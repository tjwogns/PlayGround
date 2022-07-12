package com.example.playground

import com.example.playground.retrofit.RetrofitClient
import org.junit.Test

class RetrofitUnitTest {
    private val karaokeApi by lazy {
        RetrofitClient.karaokeApi
    }

    @Test
    fun indexTest(){
        karaokeApi.getIndex("tj")
            .test()
            .assertNoErrors()
            .assertSubscribed()
            .dispose()
    }
}