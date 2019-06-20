package com.dai1678.homedisplay.net

import com.dai1678.homedisplay.entity.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("weather")
    suspend fun getCurrentLocationWeatherAsync(
        @Query("id") id: Int,
        @Query("units") units: String,
        @Query("appid") authToken: String
    ): Response<WeatherResponse>
}
