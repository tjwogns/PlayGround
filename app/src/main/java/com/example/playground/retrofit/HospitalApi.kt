package com.example.playground.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface HospitalApi {
    @GET("/Animalhospti")
    fun getHospital(
        @Query("KEY") key: String = "5355b6a276254cf3a7afef03e6b8d562",
        @Query("Type") type: String = "json",
        @Query("pIndex") index: Int,
        @Query("pSize") size: Int
    )
}