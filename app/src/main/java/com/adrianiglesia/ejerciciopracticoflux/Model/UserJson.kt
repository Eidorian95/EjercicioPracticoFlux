package com.adrianiglesia.ejerciciopracticoflux.Model


import com.google.gson.annotations.SerializedName

data class UserJson(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val users: List<User>
) {
    data class User(
        @SerializedName("cell")
        val cell: String,
        @SerializedName("dob")
        val dob: Dob,
        @SerializedName("email")
        val email: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("location")
        val location: Location,
        @SerializedName("name")
        val name: Name,
        @SerializedName("nat")
        val nat: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("picture")
        val picture: Picture,
        @SerializedName("login")
        val login: Login
    ) {
        data class Name(
            @SerializedName("first")
            val first: String,
            @SerializedName("last")
            val last: String,
            @SerializedName("title")
            val title: String
        )

        data class Login(
            @SerializedName("uuid")
            val uuid: String,
            @SerializedName("username")
            val username: String,
            @SerializedName("password")
            val password: String
        )

        data class Location(
            @SerializedName("city")
            val city: String,
            @SerializedName("coordinates")
            val coordinates: Coordinates,
            @SerializedName("postcode")
            val postcode: String,
            @SerializedName("state")
            val state: String,
            @SerializedName("street")
            val street: String
        ) {

            data class Coordinates(
                @SerializedName("latitude")
                val latitude: String,
                @SerializedName("longitude")
                val longitude: String
            )
        }

        data class Picture(
            @SerializedName("large")
            val large: String,
            @SerializedName("medium")
            val medium: String,
            @SerializedName("thumbnail")
            val thumbnail: String
        )


        data class Dob(
            @SerializedName("age")
            val age: Int,
            @SerializedName("date")
            val date: String
        )
    }

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
}