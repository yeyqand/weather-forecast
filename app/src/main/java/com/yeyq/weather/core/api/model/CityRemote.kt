package com.yeyq.weather.core.api.model

import com.google.gson.annotations.SerializedName


data class CityRemote(

    @SerializedName("geoname_id") val geoname_id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("country") val country: String,
    @SerializedName("iso2") val iso2: String,
    @SerializedName("type") val type: String,
    @SerializedName("population") val population: Int
)