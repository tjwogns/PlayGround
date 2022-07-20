package com.example.playground.retrofit

import com.example.playground.dto.KaraokeDto
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface KaraokeApi {
    @GET("/karaoke.json")
    fun getIndexWithRx(
        @Query("brand") brand: String
    ): Single<List<KaraokeDto>>

    @GET("/karaoke.json")
    suspend fun getIndexWithFlow(
        @Query("brand") brand: String
    ): List<KaraokeDto>

    @GET("/karaoke.json")
    suspend fun getIndexWithFlow2(
        @Query("brand") brand: String
    ): Flow<List<KaraokeDto>>

}