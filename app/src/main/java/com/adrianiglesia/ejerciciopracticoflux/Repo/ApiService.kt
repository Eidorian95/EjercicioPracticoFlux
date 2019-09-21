package com.adrianiglesia.ejerciciopracticoflux.Repo

import com.adrianiglesia.ejerciciopracticoflux.Model.UserJson
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=20")
    fun getAllUsers(): Call<UserJson>
}