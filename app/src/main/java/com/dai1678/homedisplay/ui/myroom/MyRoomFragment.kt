package com.dai1678.homedisplay.ui.myroom

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dai1678.homedisplay.R
import kotlinx.android.synthetic.main.my_room_fragment.*


class MyRoomFragment : Fragment() {

    companion object {
        fun newInstance() = MyRoomFragment()
    }

    private lateinit var viewModel: MyRoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_room_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyRoomViewModel::class.java)

        viewModel.weather.observe(this, Observer {
            my_room_loading.visibility = View.INVISIBLE
            weather_image.visibility = View.VISIBLE
            outdoor_temperature_text.visibility = View.VISIBLE
            indoor_temperature_text.visibility = View.VISIBLE
            when (it) {
                "01d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.super_sunny, null),
                    resources.getColor(R.color.colorClearSky, null)
                )

                "02d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.sunny, null),
                    resources.getColor(R.color.colorSky, null)
                )

                "03d", "04d", "50d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.cloudy, null),
                    resources.getColor(R.color.colorCloud, null)
                )

                "09d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.shower_rain, null),
                    resources.getColor(R.color.colorShowerRain, null)
                )

                "10d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.rain, null),
                    resources.getColor(R.color.colorRain, null)
                )

                "11d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.thunderstom, null),
                    resources.getColor(R.color.colorThunderstorm, null)
                )

                "13d" -> setWeatherInfo(
                    resources.getDrawable(R.drawable.snow, null),
                    resources.getColor(R.color.colorSnow, null)
                )
            }
        })

        viewModel.outdoorTemperature.observe(this, Observer {
            outdoor_temperature_text.text = "屋外の気温 : $it℃"
        })

        viewModel.indoorTemperature.observe(this, Observer {
            indoor_temperature_text.text = "室内の気温 : $it℃"
        })
    }

    private fun setWeatherInfo(drawable: Drawable, color: Int) {
        weather_image.setImageDrawable(drawable)
        my_room_layout.setBackgroundColor(color)
    }

}
