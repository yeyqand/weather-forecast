package com.yeyq.weather.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}