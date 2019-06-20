package com.dai1678.homedisplay.ui.mycalendar

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dai1678.homedisplay.R

class MyCalendarFragment : Fragment() {

    companion object {
        fun newInstance() = MyCalendarFragment()
    }

    private lateinit var viewModel: MyCalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_calendar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyCalendarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
