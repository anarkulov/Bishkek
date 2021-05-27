package com.erzhan.bishkek.adapters

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PlaceViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var fragmentList: ArrayList<Fragment> = ArrayList()
    private var fragmentTitles: ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitles.add(title)
    }

    fun getTabView(position: Int, context: Context): View {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        val v: View = LayoutInflater.from(context).inflate(com.erzhan.bishkek.R.layout.custom_tab, null)
        val tv = v.findViewById(com.erzhan.bishkek.R.id.customTabTextViewId) as TextView
        tv.text = fragmentTitles[position]
        return v
    }
}