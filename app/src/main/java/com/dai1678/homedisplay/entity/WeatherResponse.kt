package com.dai1678.homedisplay.entity

data class WeatherResponse (
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val id: Int,
    val name: String,
    val cod: Int
)

data class Coord ( //緯度経度
    val lon: Float,
    val lat: Float
)

data class Weather (
    val id: Int,
    val main: String, //天気名
    val description: String,
    val icon: String
)

data class Main (
    val temp: Float,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Float,
    val temp_max: Float
)

data class Wind (
    val speed: Float,
    val deg: Int
)

data class Clouds (
    val all: Int
)

data class Sys (
    val type: Int,
    val id: Int,
    val message: Float,
    val country: String,
    val sunrise: Int,
    val sunset: Int
)
