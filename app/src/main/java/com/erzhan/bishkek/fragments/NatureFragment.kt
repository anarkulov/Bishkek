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

class NatureFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    private lateinit var expandIcon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_nature, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val nature1 = "Ala Archa National Park"
        placeList.add(nature1)
        childs.add(Place(nature1, "Chuy region", R.drawable.ala_archa, "The Ala Archa National Park is an alpine national park in the Tian Shan mountains of Kyrgyzstan, established in 1976 and located approximately 40 km south of the capital city of Bishkek", "Ala-Archa, Bishkek", "42.64473502753992, 74.48022745888822", "0701 551 026"))
        childPlaceList[nature1] = childs

        val nature2 = "Ski Complex Chunkurchak"
        placeList.add(nature2)
        childs.add(Place(nature2, "Chuy region", R.drawable.ski_chunkurchak, "Chunkurchak ski base has five modern chair lifts: double, triple and three quadruple, with a total length of more than 4.5 kilometers. The maximum length of the trails is more than 10 kilometers, the difference in altitude  is about 370 meters. Convenient for all  tourists. All lifts have their own name, and differ in color.", "Bishkek", "42.63964152813866, 74.62834051813527", "0558 586 898"))
        childPlaceList.put(nature2, childs)

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