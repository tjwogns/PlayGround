package com.example.playground.retrofit

import com.example.playground.dto.HospitalDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenApi {
    @GET("/Animalhosptl")
    suspend fun getHospital(
        @Query("KEY") key: String = "5355b6a276254cf3a7afef03e6b8d562",
        @Query("Type") type: String = "json",
        @Query("pIndex") index: Int = 1,
        @Query("pSize") size: Int = 100,
        @Query("SIGUN_CD") sigunCode: String? = null,
        @Query("SIGUN_NM") sigunName: String? = null
    ): HospitalDto
}