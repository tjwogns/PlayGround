package com.example.playground.retrofit

import com.example.playground.dto.KaraokeDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KaraokeApi {
    @GET("/karaoke.json")
    fun getIndex(
        @Query("brand") brand: String
    ): Single<KaraokeDto>

}