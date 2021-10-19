package com.yeyq.weather.features.city.data

import com.yeyq.weather.core.api.WeatherApi
import com.yeyq.weather.core.exception.ErrorWrapper
import com.yeyq.weather.core.exception.callOrThrow
import com.yeyq.weather.features.city.domain.CityRepository
import com.yeyq.weather.features.city.domain.model.City
import javax.inject.Inject


class CityRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val errorWrapper: ErrorWrapper
) : CityRepository {
    override suspend fun getCity(): City {
        return callOrThrow(errorWrapper) { getCityFromRemote() }
    }

    private suspend fun getCityFromRemote(): City {
        return weatherApi.getWeatherResponse()
            .toCity()
    }
}