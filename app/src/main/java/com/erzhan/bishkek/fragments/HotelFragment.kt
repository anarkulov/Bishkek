package com.erzhan.bishkek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.erzhan.bishkek.R
import com.erzhan.bishkek.adapters.PlaceAdapter
import com.erzhan.bishkek.data.Place

class HotelFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    lateinit var expandIcon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_hotel, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val hotel1 = "Art Hotel Bishkek"
        placeList.add(hotel1)
        childs.add(Place(hotel1, "Birinchi May district", R.drawable.art_hotel_bishkek, "Art Hotel Bishkek offers air-conditioned rooms in Bishkek. Among the facilities of this property are a restaurant, a 24-hour front desk and room service, along with free WiFi. All rooms are fitted with a patio with city views. Shisha is also featured.", "10 Leshoznaya St, Bishkek", "42.882679325377346, 74.56010360947138","0556 466 550"))
        childPlaceList[hotel1] = childs

        val hotel2 = "Jannat Regency Hotel"
        placeList.add(hotel2)
        childs.add(Place(hotel2, "Oktyabr district", R.drawable.jannat, "Along with a restaurant, this smoke-free hotel has a bar/lounge and a poolside bar. Free WiFi in public areas and free self parking are also provided. Additionally, a snack bar/deli, a sauna, and a conference center are onsite. All 94 rooms boast deep soaking tubs and offer free WiFi and 24-hour room service. Minibars and premium bedding are standard, as are flat-screen TVs with satellite channels.", "21/2 Aaly Tokombayev St, Bishkek", "42.824631176072046, 74.61741046754439","0312 909 750"))
        childPlaceList.put(hotel2, childs)

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