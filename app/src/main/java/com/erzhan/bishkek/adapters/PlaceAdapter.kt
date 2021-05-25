package com.erzhan.bishkek.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.erzhan.bishkek.R
import com.erzhan.bishkek.data.Place

class PlaceAdapter(context: Context, resources: Int, items: List<Place>) :
    ArrayAdapter<Place>(context, resources , items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listView = convertView

        if (listView == null){
            listView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val place: Place? = getItem(position)

        val placeName = listView?.findViewById<TextView>(R.id.nametTextViewId)
        placeName!!.text = place!!.name

        val placeDescription = listView!!.findViewById<TextView>(R.id.descriptionTextViewId)
        placeDescription.text = place.location;

        val placeImage = listView.findViewById<ImageView>(R.id.placeImageId)

        if (place.hasImage()) {
            placeImage.setImageResource(place.imageResourceId)
        } else {
            placeImage.visibility
        }

        return listView
    }
}