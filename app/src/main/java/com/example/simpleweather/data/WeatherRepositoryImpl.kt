package com.example.simpleweather.data

import com.example.simpleweather.domain.WeatherRepository
import com.example.simpleweather.domain.entity.Weather
import com.example.simpleweather.domain.entity.WeatherDetails

class WeatherRepositoryImpl(
    private val weatherAPI: WeatherAPI
) : WeatherRepository {

    override suspend fun getWeather(q: String): Weather {

        return weatherAPI.getDailyForecast(q, appId="e5cab472a4ea4051f5e78f886651774e", units ="metric")
            .let{
                Weather(
                    city = it.name,
                    weatherMain = it.weather[0].main,
                    mainTemp = it.main.temp.toString(),
                    weatherDescription = it.weather[0].description
                )
            }
    }

    override suspend fun getWeatherDetails(q: String): WeatherDetails {

        return weatherAPI.getDailyForecast(q, appId="e5cab472a4ea4051f5e78f886651774e", units ="metric")
            .let{
                WeatherDetails(
                    temperature = it.main.temp.toString(),
                    pressure = it.main.pressure.toString(),
                    humidity = it.main.humidity.toString()
                )
            }
    }
}