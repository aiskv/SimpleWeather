package com.example.simpleweather.presentation.weatherDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.simpleweather.R
import com.example.simpleweather.databinding.WeatherDetailScreenBinding

import com.example.simpleweather.di.NetworkModule
import com.example.simpleweather.presentation.common.BaseFragment
import com.example.simpleweather.presentation.common.navigate
import com.example.simpleweather.presentation.weatherDetail.WeatherDetailFragment
import com.example.simpleweather.presentation.weatherSummary.WeatherSummaryViewModel

class WeatherDetailFragment : BaseFragment(R.layout.weather_detail_screen) {
    private val viewBinding by viewBinding(WeatherDetailScreenBinding::bind)
    private val viewModel by viewModels<WeatherDetailViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                WeatherDetailViewModel(NetworkModule.getRepository()) as T
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherState.observe(viewLifecycleOwner) {
            viewBinding.temperatureValue.text = it.temperature
            viewBinding.pressureValue.text = it.pressure
            viewBinding.humidityValue.text = it.humidity
        }

        viewBinding.weatherDetailBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }

}