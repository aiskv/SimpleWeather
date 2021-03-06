package com.example.simpleweather.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    val country: String,
    val id: Int,
    val message: Double? = null,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)