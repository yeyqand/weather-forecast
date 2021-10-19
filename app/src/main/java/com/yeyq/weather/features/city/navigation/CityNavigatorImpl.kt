package com.yeyq.weather.features.city.navigation

import com.yeyq.weather.R
import com.yeyq.weather.core.navigation.FragmentNavigator
import com.yeyq.weather.features.dayDetails.presentation.DayDetailsFragment
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import javax.inject.Inject

class CityNavigatorImpl @Inject constructor(private val fragmentNavigator: FragmentNavigator) :
    CityNavigator {
    override fun openDayDetailsScreen(day: DayDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_city_screen_to_day_details_fragment,
            DayDetailsFragment.DAY_DETAILS_KEY to day
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}