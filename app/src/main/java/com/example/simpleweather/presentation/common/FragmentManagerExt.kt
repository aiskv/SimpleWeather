package com.example.simpleweather.presentation.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.simpleweather.R.id

fun FragmentManager.navigate(fragment: Fragment) {
    commit(allowStateLoss = true) {
        replace(id.main_activity_container, fragment)
        addToBackStack(null)
    }
}