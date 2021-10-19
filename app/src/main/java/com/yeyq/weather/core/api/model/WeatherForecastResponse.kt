package com.yeyq.weather.core.api.model

import com.google.gson.annotations.SerializedName
import com.yeyq.weather.features.city.domain.model.City


data class WeatherForecastResponse(

    @SerializedName("cod") val code: Int,
    @SerializedName("message") val message: Int,
    @SerializedName("city") val city: CityRemote,
    @SerializedName("cnt") val count: Int,
    @SerializedName("list") val days: List<DayRemote>
) {
    companion object

    fun toCity() =
        City(
            name = city.name,
            days = days.map { it.toDay() }
        )
}

