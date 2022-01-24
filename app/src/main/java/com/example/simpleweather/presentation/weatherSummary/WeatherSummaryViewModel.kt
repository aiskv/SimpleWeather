package com.example.simpleweather.presentation.weatherSummary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweather.domain.WeatherRepository
import com.example.simpleweather.domain.entity.Weather
import com.example.simpleweather.presentation.common.launchWithErrorHandler

class WeatherSummaryViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weatherState = MutableLiveData<Weather>()
    val weatherState: LiveData<Weather> = _weatherState
    init {
        viewModelScope.launchWithErrorHandler {
            val weather: Weather = weatherRepository.getWeather("Moscow")
            _weatherState.value = weather
        }

    }
}

