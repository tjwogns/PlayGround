package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class HospitalDto(
    @SerializedName("Animalhosptl")
    val hospital: List<HosptlDto>? = null
)

data class HosptlDto(
    @SerializedName("head")
    val head: List<HospitalHeadDto>? = listOf(),

    @SerializedName("row")
    val row: List<HospitalRowDto>? = listOf()


)