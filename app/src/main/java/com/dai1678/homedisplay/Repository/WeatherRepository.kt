package com.dai1678.homedisplay.Repository

import com.dai1678.homedisplay.entity.WeatherResponse
import com.dai1678.homedisplay.net.OpenWeatherApiClient.openWeatherApi

class WeatherRepository : BaseRepository() {

    private val authToken = "" //FIXME

    companion object Factory {
        private var instance: WeatherRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: WeatherRepository().also { instance = it }
        }
    }

    suspend fun callCurrentLocationWeatherAsync(): WeatherResponse? {
        return safeApiCall(
            call = openWeatherApi.getCurrentLocationWeatherAsync(id = 1863357, units = "metric", authToken = authToken),
            error = "API Call Error"
        )
    }


}
