package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class HospitalHeadDto(
    @SerializedName("list_total_count")
    val totalCount: Int = 0,

    @SerializedName("RESULT")
    val result: HospitalHeadResultDto,

    @SerializedName("api_version")
    val apiVersion: String? = "0.0"
)


data class HospitalHeadResultDto(
    @SerializedName("CODE")
    val code: String? = null,

    @SerializedName("MESSAGE")
    val message: String? = null
)
