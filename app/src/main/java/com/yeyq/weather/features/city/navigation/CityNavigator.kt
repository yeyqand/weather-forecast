package com.yeyq.weather.features.city.navigation

import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable


interface CityNavigator {
    fun openDayDetailsScreen(day: DayDisplayable)
    fun goBack()
}