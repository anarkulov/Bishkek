package com.erzhan.bishkek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.erzhan.bishkek.adapters.PlaceViewPagerAdapter
import com.erzhan.bishkek.fragments.*
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var placeViewPagerAdapter: PlaceViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tabLayoutId)
        viewPager = findViewById(R.id.viewPagerId)
        placeViewPagerAdapter = PlaceViewPagerAdapter(supportFragmentManager)

        placeViewPagerAdapter.addFragment(ArtFragment(), "Art")
        placeViewPagerAdapter.addFragment(GovernmentFragment(), "Government")
        placeViewPagerAdapter.addFragment(HistoryFragment(), "History")
        placeViewPagerAdapter.addFragment(HotelFragment(), "Hotel")
        placeViewPagerAdapter.addFragment(NatureFragment(), "Nature")
        placeViewPagerAdapter.addFragment(RestaurantFragment(), "Restaurant")

        viewPager.adapter = placeViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}