package com.yeyq.weather.features.dayDetails.domain.model

data class Day(
    val date: Int,
    val temperatureMin: Double,
    val temperatureMax: Double,
    val temperatureDay: Double,
    val icon: String,
    val description: String,
    val pressure: Double,
    val windSpeed: Double
) {
    companion object
}