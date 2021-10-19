package com.yeyq.weather.core.adapter

interface BindableAdapter<T> {
    fun setItems(items: List<T>)
}