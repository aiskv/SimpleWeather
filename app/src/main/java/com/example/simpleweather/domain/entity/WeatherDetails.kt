package com.example.simpleweather.domain.entity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class WeatherDetails (
    val temperature : String,
    val pressure : String,
    val humidity : String
) : Parcelable

