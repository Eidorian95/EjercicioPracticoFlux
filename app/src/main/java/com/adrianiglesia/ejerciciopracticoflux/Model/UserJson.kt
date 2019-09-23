package com.adrianiglesia.ejerciciopracticoflux.Model


import com.google.gson.annotations.SerializedName

data class UserJson(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val users: List<User>
)