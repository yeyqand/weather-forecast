package com.yeyq.weather.features.city.domain

import com.yeyq.weather.core.base.UseCase
import com.yeyq.weather.features.city.domain.model.City

class GetCityUseCase(private val cityRepository: CityRepository) :
    UseCase<City, Unit>() {

    override suspend fun action(params: Unit) = cityRepository.getCity()
}