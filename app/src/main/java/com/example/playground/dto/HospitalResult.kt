package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class HospitalResult(
    val head: HospitalHeadDto? = null,

    val row: List<HospitalRowDto>? = listOf()
)