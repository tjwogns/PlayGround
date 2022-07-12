package com.example.playground.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val KARAOKE_BASE_URL = "https://api.manana.kr"

    val karaokeApi: KaraokeApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(KARAOKE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

        retrofit.create(KaraokeApi::class.java)
    }
}