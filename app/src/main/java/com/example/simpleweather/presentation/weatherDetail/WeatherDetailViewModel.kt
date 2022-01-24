package com.example.simpleweather.presentation.weatherDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweather.domain.WeatherRepository
import com.example.simpleweather.domain.entity.Weather
import com.example.simpleweather.domain.entity.WeatherDetails
import com.example.simpleweather.presentation.common.launchWithErrorHandler

class WeatherDetailViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _weatherState = MutableLiveData<WeatherDetails>()
    val weatherState: LiveData<WeatherDetails> = _weatherState
    init {
        viewModelScope.launchWithErrorHandler {
            val weather: WeatherDetails = weatherRepository.getWeatherDetails("Moscow")
            _weatherState.value = weather
        }

    }
}