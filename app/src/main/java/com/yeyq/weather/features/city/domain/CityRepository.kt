package com.yeyq.weather.features.city.domain

import com.yeyq.weather.features.city.domain.model.City

interface CityRepository {
    suspend fun getCity(): City
}