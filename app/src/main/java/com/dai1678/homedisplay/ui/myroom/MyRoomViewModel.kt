package com.dai1678.homedisplay.ui.myroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dai1678.homedisplay.Repository.NatureRemoRepository
import com.dai1678.homedisplay.Repository.WeatherRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyRoomViewModel : ViewModel() {
    private val weatherRepository = WeatherRepository.getInstance()
    private val natureRemoRepository = NatureRemoRepository.getInstance()

    private val _weatherIconId = MutableLiveData<String>()
    val weather: LiveData<String> = _weatherIconId

    private val _outdoorTemperature = MutableLiveData<Float>()
    val outdoorTemperature: LiveData<Float> = _outdoorTemperature

    private val _indoorTemperature = MutableLiveData<Float>()
    val indoorTemperature: LiveData<Float> = _indoorTemperature

    init {
        getWeather()
        getIndoorTemperature()
    }

    private fun getWeather() {
        GlobalScope.launch {
            val weatherResponse = weatherRepository.callCurrentLocationWeatherAsync() ?: return@launch
            _outdoorTemperature.postValue(weatherResponse.main.temp)
            _weatherIconId.postValue(weatherResponse.weather[0].icon)
        }
    }

    private fun getIndoorTemperature() {
        GlobalScope.launch {
            val temperatureResponse = natureRemoRepository.callMyDeviceInfosAsync() ?: return@launch
            _indoorTemperature.postValue(temperatureResponse[0].newest_events.te.value)
        }
    }
}
