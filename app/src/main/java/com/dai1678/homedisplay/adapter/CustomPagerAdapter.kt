package com.dai1678.homedisplay.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class CustomPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragmentList = ArrayList<Fragment>()

    override fun getItemPosition(`object`: Any): Int {
        val target = `object` as Fragment
        if (fragmentList.contains(target)) {
            return PagerAdapter.POSITION_UNCHANGED
        }

        return PagerAdapter.POSITION_NONE
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
//        return fragmentList[position]
        val index = position % fragmentList.size
        return fragmentList[index]
    }

    override fun getCount(): Int {
//        return fragmentList.size
        return if (fragmentList.size == 0) {
            0
        } else {
            fragmentList.size + 2
        }
    }

    fun getRealCount(): Int {
        return fragmentList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val modelPosition = mapPagerPositionToModelPosition(position)

        val fragment = fragmentList[modelPosition]

        return super.instantiateItem(container, position)
    }

    private fun mapPagerPositionToModelPosition(pagerPosition: Int): Int {
        if (pagerPosition == 0) {
            return getRealCount() - 1
        }
        if (pagerPosition == getRealCount() + 1) {
            return 0
        }
        return pagerPosition - 1
    }

    fun refresh() {
        fragmentList.clear()
        notifyDataSetChanged()
    }
}
