package com.yeyq.weather.features.city.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.yeyq.weather.core.base.BaseViewModel
import com.yeyq.weather.core.exception.ErrorMapper
import com.yeyq.weather.features.city.domain.GetCityUseCase
import com.yeyq.weather.features.city.domain.model.City
import com.yeyq.weather.features.city.navigation.CityNavigator
import com.yeyq.weather.features.city.presentation.model.CityDisplayable
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val getCityUseCase: GetCityUseCase,
    private val cityNavigator: CityNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _city by lazy {
        MutableLiveData<City>()
            .also(this::getCity)
    }

    val city: LiveData<CityDisplayable> by lazy {
        _city.map { CityDisplayable(it) }
    }

    private fun getCity(cityLiveData: MutableLiveData<City>) {
        setPendingState()
        getCityUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            result.onSuccess {
                setIdleState()
                cityLiveData.value = it
            }
            result.onFailure(this::handleFailure)
        }
    }

    fun onDayClick(day: DayDisplayable) {
        cityNavigator.openDayDetailsScreen(day)
    }

}