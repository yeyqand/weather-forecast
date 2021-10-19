package com.yeyq.weather.mock

import com.yeyq.weather.features.city.domain.model.City
import com.yeyq.weather.features.dayDetails.domain.model.Day
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import org.jetbrains.annotations.TestOnly
import java.util.Collections.emptyList


@TestOnly
fun Day.Companion.mock() = Day(
    date = 1,
    temperatureMin = 0.1,
    temperatureMax = 0.2,
    temperatureDay = 0.3,
    icon = "day icon",
    description = "day description",
    pressure = 0.4,
    windSpeed = 0.5
)

@TestOnly
fun DayDisplayable.Companion.mock() = DayDisplayable(
    Day.mock(), "city name"
)

@TestOnly
fun City.Companion.mock() = City(
    name = "city_name",
    days = emptyList()
)
