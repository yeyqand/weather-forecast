package com.yeyq.weather.features.city.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCityUseCaseTest {

    @Test
    fun `when use case is invoked than execute getCity method from repository`() {
        //given
        val repository = mockk<CityRepository>(relaxed = true)
        val useCase = GetCityUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCity() }
    }
}