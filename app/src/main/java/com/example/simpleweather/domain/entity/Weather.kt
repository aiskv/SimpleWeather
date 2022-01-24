package com.example.simpleweather.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather (
    val city : String,
    val weatherMain : String,
    val mainTemp : String,
    val weatherDescription : String,
) : Parcelable