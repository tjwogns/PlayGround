package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class HospitalDto(
    @SerializedName("head")
    val head: HospitalHeadDto? = null,
    val row: List<HospitalRowDto>? = listOf()
)