package com.example.simpleweather.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherNw(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)