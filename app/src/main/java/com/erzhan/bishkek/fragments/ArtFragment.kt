package com.erzhan.bishkek.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.ExpandableListView.OnChildClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.erzhan.bishkek.R
import com.erzhan.bishkek.adapters.PlaceAdapter
import com.erzhan.bishkek.data.Place


class ArtFragment : Fragment() {

    lateinit var placeList: ArrayList<String>
    lateinit var childPlaceList: HashMap<String, ArrayList<Place>>
    lateinit var childs: ArrayList<Place>
    lateinit var listView: ExpandableListView
    var isExpand = false
    lateinit var expandIcon: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view : View = inflater.inflate(R.layout.fragment_art, container, false)

        placeList = ArrayList()
        childs = ArrayList()
        childPlaceList = HashMap()

        val art2 = "National Museum of Fine Arts"
        placeList.add(art2)
        childs.add(Place(art2, "Lenin district", R.drawable.gapar_aitiev, "The National Museum of Fine Arts (Filipino: Pambansang Museo ng Sining), formerly known as the National Art Gallery, is an art museum in Manila, Philippines. It is located on Padre Burgos Avenue across from the National Museum of Anthropology in the eastern side of Rizal Park.", "196 Yusup Abdrahmanov St, Bishkek", "42.87876988935866, 74.6108699623201", "+ 996 312 621 641"))
        childPlaceList.put(art2, childs)

        val art3 = "Asanbay Gallery"
        placeList.add(art3)
        childs.add(Place(art3, "Oktyabr district", R.drawable.asanbay, "Multi-disciplinary cultural venue in Bishkek for people to gather and to enrich their life through art, education, and entertainment-related programs", "21/4 Aaly Tokombaev St, Bishkek", "42.81756533266686, 74.6202737068875", "+996 775 979 500"))
        childPlaceList.put(art3, childs)


        val art4 = "SAIMALUU TASH Art Gallery"
        placeList.add(art4)
        childs.add(Place(art4, "Oktyabr district", R.drawable.saimaluu_tash, "The souvenir store where you can find handmade goods from all over Kyrgyzstan, from souvenirs to artworks of a local master hands. The Art Gallery itself produces hand embroidered wall carpets, patchwork panels for interior decoration. Using old, traditional methods and technics of execution we deliver new looking accessories with new design, consisting a yore authenticity of kyrgyz art.", "136/33 Panfilov St, Bishkek", "42.866625763468456, 74.59983623376394","+996 550 826 050"))
        childPlaceList.put(art4, childs)

        val placeAdapter = context?.let { PlaceAdapter(activity as AppCompatActivity, it, placeList, childPlaceList) }
        listView = view.findViewById(R.id.ExpandableListViewId)
        listView.setAdapter(placeAdapter)

        listView.setOnGroupClickListener { _, v, _, _ ->
            expandIcon = v.findViewById(R.id.expandImageViewId)
            if (isExpand){
                expandIcon.setImageResource(R.drawable.ic_more)
                isExpand = false
            } else {
                expandIcon.setImageResource(R.drawable.ic_less)
                isExpand = true
            }

            false
        }
        return view
    }


}