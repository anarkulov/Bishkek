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

class HistoryFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    lateinit var expandIcon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_history, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val national = "State History Museum"
        placeList.add(national)
        childs.add(Place(national, "Lenin district", R.drawable.statemuseum, "The museum is the biggest museum where you can find the artifacts from Neolithic period till Soviet period.\n", "Chuy Ave, Ala-Too Square, Bishkek 720000 Kyrgyzstan", "0312 626 090"))
        childPlaceList[national] = childs

        val history1 = "Monument to Manas"
        placeList.add(history1)
        childs.add(Place(history1, "Lenin district", R.drawable.manas, "Admire the impressive statue of the national icon at Monument to Manas the Great, a centrally located monument in Ala-Too Square. Erected in 2011 to celebrate the 20th anniversary of the nation's independence, the statue portrays the main protagonist of a national epic written in an 18th-century Persian manuscript", "Chuy Ave, Bishkek, Ala Too Square", "42.875799265696706, 74.603680326661"))
        childPlaceList[history1] = childs

        val history2 = "Victory Square"
        placeList.add(history2)
        childs.add(Place(history2, "Sverdlov district", R.drawable.victory_square, "Victory Square is a Memorial park and a public square in the city of Bishkek, the capital of Kyrgyzstan. It is dedicated to the Victory in the Victory over Nazi Germany. It was created in 1985, on the occasion of the 40th anniversary of the end of the Second World War.", "Bishkek","42.87928911466087, 74.61606404810425"))
        childPlaceList.put(history2, childs)

        val history3 = "Bishkek Central Mosque"
        placeList.add(history3)
        childs.add(Place(history3, "Sverdlov district", R.drawable.mosque, "The central mosque is the largest in Kyrgyzstan. It is the exact copy of Kocatepe mosque that is located in Ankara, Turkey. This is the main architectural attraction of Bishkek built on the spot of Issyk-Kul cinema, the historical centre of the capital. The choice of location caused controversy; before the construction of the theatre, there was a Christian cemetery.", "Bishkek", "42.883580199563376, 74.6197602879017", "0701 636 655"))
        childPlaceList.put(history3, childs)

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