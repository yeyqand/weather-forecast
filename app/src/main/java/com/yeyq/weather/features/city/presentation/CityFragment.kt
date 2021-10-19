package com.yeyq.weather.features.city.presentation

import androidx.fragment.app.viewModels
import com.yeyq.weather.BR
import com.yeyq.weather.R
import com.yeyq.weather.core.base.BaseFragment
import com.yeyq.weather.databinding.FragmentCityBinding
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CityFragment : BaseFragment<CityViewModel, FragmentCityBinding>(
    BR.viewModel,
    R.layout.fragment_city
), DayAdapter.OnDayListener {

    @Inject
    lateinit var adapter: DayAdapter

    override val viewModel: CityViewModel by viewModels()

    override fun initViews(binding: FragmentCityBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCityBinding) {
        binding.recyclerView.adapter = adapter
        adapter.listener = this
    }

    override fun onClick(dayDisplayable: DayDisplayable) {
        viewModel.onDayClick(dayDisplayable)
    }
}