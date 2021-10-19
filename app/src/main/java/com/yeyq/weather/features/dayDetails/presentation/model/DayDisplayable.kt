package com.yeyq.weather.features.dayDetails.presentation.model

import android.os.Parcelable
import com.yeyq.weather.core.utils.*
import com.yeyq.weather.features.dayDetails.domain.model.Day
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayDisplayable(
    val cityName: String,
    val date: String,
    val temperatureMin: String,
    val temperatureMax: String,
    val temperatureDay: String,
    val iconUrl: String,
    val description: String,
    val pressure: String,
    val windSpeed: String
) :
    Parcelable {
    constructor(day: Day, cityName: String) : this(
        cityName = cityName,
        date = day.date.toDateDisplayable(),
        temperatureMin = day.temperatureMin.formatTemperature(),
        temperatureMax = day.temperatureMax.formatTemperature(),
        temperatureDay = day.temperatureDay.formatTemperature(),
        iconUrl = day.icon.provideIconUrl(),
        description = day.description,
        pressure = day.pressure.formatPressure(),
        windSpeed = day.windSpeed.formatWindSpeed()
    )

    companion object
}

