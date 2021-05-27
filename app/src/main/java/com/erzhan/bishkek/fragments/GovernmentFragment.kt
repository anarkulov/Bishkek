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

class GovernmentFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    lateinit var expandIcon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_government, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val government1 = "White Hose"
        placeList.add(government1)
        childs.add(Place(government1, "Lenin district", R.drawable.white_house, "The White House is the presidential office building in Bishkek, Kyrgyzstan. The White House was the site of riots during both the 2005 Tulip Revolution and the 2010 Kyrgyzstani riots. During the 2010 riots a fire broke out and damaged portions of the building and destroyed the hard copies of many government records.", "Chuy Avenue, Bishkek", "42.877436,74.600348"))
        childPlaceList[government1] = childs

        val government2 = "Population Service Centre 1"
        placeList.add(government2)
        childs.add(Place(government2, "Lenin district", R.drawable.psc, "Department of Civil Status Records, Passportization and Registration of the Population of the Leninsky District", " 4 Jash Gvardiya Blvd, Bishkek", "42.86974471857349, 74.57509572929487","0312 986 192"))
        childPlaceList.put(government2, childs)


        val government3 = "Police station"
        placeList.add(government3)
        childs.add(Place(government3, "Sverdlov district", R.drawable.police, "Main Directorate of the State Specialized Security Service of the Ministry of Internal Affairs of the Kyrgyz Republic", "58 Kiev St, Bishkek","42.87412371693313, 74.6132840942661", "0312 431 193"))
        childPlaceList.put(government3, childs)

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