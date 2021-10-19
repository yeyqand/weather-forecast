package com.yeyq.weather.features.city.domain.model

import com.yeyq.weather.features.dayDetails.domain.model.Day

data class City(val name: String, val days: List<Day>) {
    companion object
}