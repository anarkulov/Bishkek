package com.erzhan.bishkek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.erzhan.bishkek.R
import com.erzhan.bishkek.adapters.PlaceAdapter
import com.erzhan.bishkek.data.Place

class RestaurantFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    lateinit var expandIcon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_restaurant, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val restaurant = "Frunze Restaurant"
        placeList.add(restaurant)
        childs.add(Place(restaurant, "Oktyabr district", R.drawable.frunze_restaurant, "The key to success of FRUNZE is, first of all, the diverse zoning of the restaurant, which allows you to choose the location of your liking. The creative concept of FRUNZE is a beautiful interior, exquisite cuisine, several halls, decorated in different styles and having their own meaning.", "205 Abdymomunov St, Bishkek" , "42.87900183727316, 74.60697981999095", "0312 664 466"))
        childPlaceList[restaurant] = childs

        val restaurant2 = "Cyclone Restaurant"
        placeList.add(restaurant2)
        childs.add(Place(restaurant2, "Lenin district", R.drawable.cyclone, "“Cyclone” – Is a place where you can feel the Italian hospitality, friendly atmosphere with personnel and of course our amazing traditional Italian cuisine.", "Chuy Ave, Bishkek", "42.87607409020109, 74.59518787581366", "0700 533 633"))
        childPlaceList.put(restaurant2, childs)

        val placeAdapter = context?.let { PlaceAdapter(activity as AppCompatActivity, it, placeList, childPlaceList) }
        listView = view.findViewById(R.id.ExpandableListViewId)
        listView.setAdapter(placeAdapter)

        listView.setOnGroupClickListener { _, v, _, _ ->
            expandIcon = v.findViewById(R.id.expandImageViewId)
            isExpand = if (isExpand){
                expandIcon.setImageResource(R.drawable.ic_more)
                false
            } else {
                expandIcon.setImageResource(R.drawable.ic_less)
                true
            }
            false
        }

        return view
    }
}