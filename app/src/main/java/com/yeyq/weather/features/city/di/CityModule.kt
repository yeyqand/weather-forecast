package com.yeyq.weather.features.city.di

import com.yeyq.weather.features.city.data.CityRepositoryImpl
import com.yeyq.weather.features.city.domain.CityRepository
import com.yeyq.weather.features.city.domain.GetCityUseCase
import com.yeyq.weather.features.city.navigation.CityNavigator
import com.yeyq.weather.features.city.navigation.CityNavigatorImpl
import com.yeyq.weather.features.city.presentation.CityFragment
import com.yeyq.weather.features.city.presentation.DayAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CityModule {
    @Binds
    abstract fun bindCityRepositoryImpl(repository: CityRepositoryImpl):
            CityRepository

    @Binds
    abstract fun bindCityNavigatorImpl(navigator: CityNavigatorImpl):
            CityNavigator

    companion object {
        @Provides
        fun provideCityUseCase(cityRepository: CityRepository) =
            GetCityUseCase(cityRepository)

        @Provides
        fun provideCityFragment() =
            CityFragment()

        @Provides
        fun provideDayAdapter() =
            DayAdapter()
    }
}