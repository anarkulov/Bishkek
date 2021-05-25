package com.erzhan.bishkek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.erzhan.bishkek.R
import com.erzhan.bishkek.adapters.PlaceAdapter
import com.erzhan.bishkek.data.Place

class HistoryFragment : Fragment() {

    lateinit var placeList: ArrayList<Place>
    lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_government, container, false)

        placeList = ArrayList()

        placeList.add(Place("History 1", "History location 1", R.drawable.bishkek_panorama))
        placeList.add(Place("History 2", "History location 2", R.drawable.bishkek_panorama))

        val placeAdapter = context?.let { PlaceAdapter(it, 0, placeList) }
        listView = view.findViewById(R.id.listItemViewId)

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            Toast.makeText(context, "More details is not implemented yet!", Toast.LENGTH_LONG).show()
        }

        listView.adapter = placeAdapter


        return view
    }
}