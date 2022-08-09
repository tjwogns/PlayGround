package com.example.playground.dto

import com.google.gson.annotations.SerializedName

data class KaraokeDto(
    @SerializedName("brand") val brand: String,
    @SerializedName("no") val no: String,
    @SerializedName("title") val title: String,
    @SerializedName("singer") val singer: String,
    @SerializedName("composer") val composer: String,
    @SerializedName("lyricist") val lyricist: String,
    @SerializedName("release") val release: String
)
