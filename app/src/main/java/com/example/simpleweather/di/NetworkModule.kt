package com.example.simpleweather.di

import com.example.simpleweather.data.WeatherAPI
import com.example.simpleweather.data.WeatherRepositoryImpl
import com.example.simpleweather.domain.WeatherRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create


object NetworkModule {

    private val weatherAPI: WeatherAPI = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build()
        )
        .addConverterFactory(
            Json(builderAction = {
                isLenient = true
                ignoreUnknownKeys = true
            }).asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create()

    private var repository: WeatherRepository? = null

    fun getRepository(): WeatherRepository =
        repository ?: WeatherRepositoryImpl(weatherAPI).also { repository = it }
}