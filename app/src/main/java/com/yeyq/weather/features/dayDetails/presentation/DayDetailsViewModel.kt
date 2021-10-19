package com.yeyq.weather.features.dayDetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yeyq.weather.core.base.BaseViewModel
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DayDetailsViewModel @Inject constructor() : BaseViewModel() {

    private val _day by lazy { MutableLiveData<DayDisplayable>() }

    val day: LiveData<DayDisplayable> by lazy {
        _day
    }

    fun onDayPassed(day: DayDisplayable) {
        _day.value = day
    }
}