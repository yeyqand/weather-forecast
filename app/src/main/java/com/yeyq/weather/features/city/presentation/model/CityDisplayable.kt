package com.yeyq.weather.features.city.presentation.model

import android.os.Parcelable
import com.yeyq.weather.core.utils.formatTemperature
import com.yeyq.weather.core.utils.temperatureAverage
import com.yeyq.weather.features.city.domain.model.City
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CityDisplayable(
    val name: String,
    val temperatureAverage: String,
    val days: List<DayDisplayable>
) : Parcelable {
    constructor(city: City) : this(
        name = city.name,
        temperatureAverage = city.days.temperatureAverage().formatTemperature(),
        days = city.days.map { DayDisplayable(it, city.name) }
    )
}