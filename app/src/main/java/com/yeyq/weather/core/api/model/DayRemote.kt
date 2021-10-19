package com.yeyq.weather.core.api.model

import com.google.gson.annotations.SerializedName
import com.yeyq.weather.core.utils.convertKelvinToCelsius
import com.yeyq.weather.features.dayDetails.domain.model.Day


data class DayRemote(

    @SerializedName("dt") val date: Int,
    @SerializedName("temp") val temperature: TemperatureRemote,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("weather") val weather: List<WeatherRemote>,
    @SerializedName("speed") val windSpeed: Double,
    @SerializedName("deg") val degrees: Int,
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("snow") val snow: Double
) {
    companion object

    fun toDay() =
        Day(
            date = date,
            temperatureMin = temperature.min.convertKelvinToCelsius(),
            temperatureMax = temperature.max.convertKelvinToCelsius(),
            temperatureDay = temperature.day.convertKelvinToCelsius(),
            icon = weather.first().icon,
            description = weather.first().description,
            pressure = pressure,
            windSpeed = windSpeed
        )


}
