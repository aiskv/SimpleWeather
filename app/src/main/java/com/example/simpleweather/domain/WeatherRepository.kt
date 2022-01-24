package com.example.simpleweather.domain

import com.example.simpleweather.domain.entity.Weather
import com.example.simpleweather.domain.entity.WeatherDetails

interface WeatherRepository {
    suspend fun getWeather(q: String): Weather

    suspend fun getWeatherDetails(q: String): WeatherDetails
}