package com.yeyq.weather.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}