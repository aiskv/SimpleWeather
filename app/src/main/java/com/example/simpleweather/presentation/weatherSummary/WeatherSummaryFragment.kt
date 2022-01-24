package com.example.simpleweather.presentation.weatherSummary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.simpleweather.R
import com.example.simpleweather.databinding.WeatherSummaryScreenBinding
import com.example.simpleweather.di.NetworkModule
import com.example.simpleweather.presentation.common.BaseFragment
import com.example.simpleweather.presentation.common.navigate
import com.example.simpleweather.presentation.weatherDetail.WeatherDetailFragment

class WeatherSummaryFragment : BaseFragment(R.layout.weather_summary_screen) {
    private val viewBinding by viewBinding(WeatherSummaryScreenBinding::bind)
    private val viewModel by viewModels<WeatherSummaryViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                WeatherSummaryViewModel(NetworkModule.getRepository()) as T
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherState.observe(viewLifecycleOwner) {
            viewBinding.city.text = it.city
            viewBinding.main.text = it.weatherMain
            viewBinding.temp.text = it.mainTemp
            viewBinding.description.text = it.weatherDescription
        }

        viewBinding.button.setOnClickListener{
            parentFragmentManager.navigate(WeatherDetailFragment())
        }
    }

}

