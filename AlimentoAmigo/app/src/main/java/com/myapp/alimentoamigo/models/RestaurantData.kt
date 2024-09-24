package com.myapp.alimentoamigo.models

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class RestaurantData (
        val name: String,
        val highlight: String,
        val image: Int,
        val description: String,
        val lat: Double,
        val long: Double,
) : Parcelable
