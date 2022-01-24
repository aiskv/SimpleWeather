package com.example.simpleweather.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.simpleweather.R
import com.example.simpleweather.databinding.MainActivityBinding
import com.example.simpleweather.presentation.common.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}