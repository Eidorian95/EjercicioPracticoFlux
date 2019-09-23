package com.adrianiglesia.ejerciciopracticoflux.Model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: Int,
    @SerializedName("users")
    val results: Int,
    @SerializedName("seed")
    val seed: String,
    @SerializedName("version")
    val version: String
)