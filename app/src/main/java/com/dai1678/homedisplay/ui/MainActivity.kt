package com.dai1678.homedisplay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dai1678.homedisplay.R
import com.dai1678.homedisplay.adapter.CustomPagerAdapter
import com.dai1678.homedisplay.ui.mycalendar.MyCalendarFragment
import com.dai1678.homedisplay.ui.myroom.MyRoomFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Skeleton of an Android Things activity.
 *
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 *
 * <pre>{@code
 * val service = PeripheralManagerService()
 * val mLedGpio = service.openGpio("BCM6")
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
 * mLedGpio.value = true
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

//        val fragmentManager = supportFragmentManager
//        val adapter = CustomPagerAdapter(fragmentManager)
//        adapter.addFragment(MyRoomFragment.newInstance())
//        adapter.addFragment(MyCalendarFragment.newInstance())
//        view_pager.adapter = adapter

//        val listener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
//
//            private var jumpPosition = -1
//
//            override fun onPageScrollStateChanged(state: Int) {
//                if (state == ViewPager.SCROLL_STATE_IDLE && jumpPosition >= 0) {
//                    view_pager.setCurrentItem(jumpPosition, false)
//                    jumpPosition = -1
//                }
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            }
//
//            override fun onPageSelected(position: Int) {
//                if (position == 0) {
//                    jumpPosition =
//                }
//            }
//
//        }
    }
}
