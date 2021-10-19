package com.yeyq.weather.features.city.presentation

import androidx.lifecycle.viewModelScope
import com.yeyq.weather.core.base.UiState
import com.yeyq.weather.core.exception.ErrorMapper
import com.yeyq.weather.features.city.domain.GetCityUseCase
import com.yeyq.weather.features.city.navigation.CityNavigator
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import com.yeyq.weather.mock.mock
import com.yeyq.weather.utils.ViewModelTest
import com.yeyq.weather.utils.getOrAwaitValue
import com.yeyq.weather.utils.observeForTesting
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CityViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN day is clicked THEN open day details screen`() {
        //given
        val useCase = mockk<GetCityUseCase>(relaxed = true)
        val cityNavigator = mockk<CityNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CityViewModel(useCase, cityNavigator, errorMapper)
        val day = DayDisplayable.mock()

        //when
        viewModel.onDayClick(day)

        //then
        verify { cityNavigator.openDayDetailsScreen(day) }
    }

    @Test
    fun `WHEN city live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCityUseCase>(relaxed = true)
        val cityNavigator = mockk<CityNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CityViewModel(useCase, cityNavigator, errorMapper)

        //when
        viewModel.city.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN city live data is observed THEN invoke use case to get city`() {
        //given
        val useCase = mockk<GetCityUseCase>(relaxed = true)
        val cityNavigator = mockk<CityNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CityViewModel(useCase, cityNavigator, errorMapper)

        //when
        viewModel.city.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

}