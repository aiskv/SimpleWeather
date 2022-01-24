package com.example.simpleweather.data

import com.example.simpleweather.data.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/data/2.5/weather")
    suspend fun getDailyForecast(
        @Query("q") q: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): WeatherResponse

}