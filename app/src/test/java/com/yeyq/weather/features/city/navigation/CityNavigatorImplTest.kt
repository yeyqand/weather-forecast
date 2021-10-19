package com.yeyq.weather.features.city.navigation

import com.yeyq.weather.R
import com.yeyq.weather.core.navigation.FragmentNavigator
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import com.yeyq.weather.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CityNavigatorImplTest {

    @Test
    fun `WHEN openDayDetailsScreen is called THEN invoke navigateTo method of FragmentNavigator with appropriate action and day model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val cityNavigator: CityNavigator = CityNavigatorImpl(fragmentNavigator)
        val day = DayDisplayable.mock()
        val slot = slot<Pair<String, DayDisplayable>>()

        //when
        cityNavigator.openDayDetailsScreen(day)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_city_screen_to_day_details_fragment,
                capture(slot)
            )
        }
        slot.captured.second shouldBe day
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val cityNavigator: CityNavigator = CityNavigatorImpl(fragmentNavigator)

        //when
        cityNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }
}
