package com.yeyq.weather.features.dayDetails.presentation

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.yeyq.weather.BR
import com.yeyq.weather.R
import com.yeyq.weather.core.base.BaseFragment
import com.yeyq.weather.databinding.FragmentDayBinding
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DayDetailsFragment :
    BaseFragment<DayDetailsViewModel, FragmentDayBinding>(
        BR.viewModel,
        R.layout.fragment_day
    ) {

    override val viewModel: DayDetailsViewModel by viewModels()

    companion object {
        const val DAY_DETAILS_KEY = "dayDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<DayDisplayable>(DAY_DETAILS_KEY)
            ?.let { viewModel.onDayPassed(it) }
    }
}