package com.yeyq.weather.core.api

import com.yeyq.weather.core.ENDPOINT
import com.yeyq.weather.core.api.model.WeatherForecastResponse
import retrofit2.http.GET

interface WeatherApi {

    @GET(ENDPOINT)
    suspend fun getWeatherResponse(): WeatherForecastResponse

}