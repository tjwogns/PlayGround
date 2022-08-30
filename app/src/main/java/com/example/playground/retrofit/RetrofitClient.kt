package com.example.playground.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val KARAOKE_BASE_URL = "https://api.manana.kr"
    private const val GG_OPENAPI_BASE_URL = "https://openapi.gg.go.kr"

    val karaokeApi: KaraokeApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(KARAOKE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

        retrofit.create(KaraokeApi::class.java)
    }

    val openApi: OpenApi by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(GG_OPENAPI_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

        retrofit.create(OpenApi::class.java)
    }
}