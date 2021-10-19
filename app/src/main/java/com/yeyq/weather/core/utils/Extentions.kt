package com.yeyq.weather.core.utils

import com.yeyq.weather.features.dayDetails.domain.model.Day
import java.text.SimpleDateFormat
import java.util.*

const val KELVIN_CELSIUS_DIFFERENCE = 273.15
const val DATE_FORMAT_PATTERN = "EEEE, dd-MM-yyyy"
const val MILLISECONDS_IN_SEC = 1000L
const val CELSIUS_SUFFIX = "°C"
const val PRESSURE_SUFFIX = " hPa"
const val SPEED_SUFFIX = " m/s"
const val ICON_URL = "https://openweathermap.org/img/w/%icon%.png"


fun Double.convertKelvinToCelsius() = this - KELVIN_CELSIUS_DIFFERENCE
fun List<Day>.temperatureAverage() = (this.map { it.temperatureDay }).average()
fun Int.toDateDisplayable(): String =
    SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH).format(Date(this * MILLISECONDS_IN_SEC))

fun Double.formatTemperature() = this.toInt().toString() + CELSIUS_SUFFIX
fun Double.formatPressure() = this.toInt().toString() + PRESSURE_SUFFIX
fun Double.formatWindSpeed() = this.toInt().toString() + SPEED_SUFFIX
fun String.provideIconUrl() = ICON_URL.replace("%icon%", this)