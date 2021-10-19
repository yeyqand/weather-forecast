package com.yeyq.weather.features.city.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.weather.core.base.BaseAdapter
import com.yeyq.weather.databinding.ItemDayBinding
import com.yeyq.weather.features.dayDetails.presentation.model.DayDisplayable

class DayAdapter : BaseAdapter<DayDisplayable>() {
    lateinit var listener: OnDayListener

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): DayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDayBinding.inflate(inflater, parent, false)

        return DayViewHolder(binding, listener)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val day = items[position]
        (holder as DayViewHolder).bind(day)
    }

    class DayViewHolder(
        private val binding: ItemDayBinding,
        private val listener: OnDayListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(day: DayDisplayable) {
            with(binding) {
                item = day
                root.setOnClickListener { listener.onClick(day) }
                executePendingBindings()
            }
        }
    }

    interface OnDayListener {
        fun onClick(dayDisplayable: DayDisplayable)
    }
}