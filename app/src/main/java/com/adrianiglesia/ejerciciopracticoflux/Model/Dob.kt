package com.adrianiglesia.ejerciciopracticoflux.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dob(
    @SerializedName("age")
    val age: Int,
    @SerializedName("date")
    val date: String
) : Parcelable