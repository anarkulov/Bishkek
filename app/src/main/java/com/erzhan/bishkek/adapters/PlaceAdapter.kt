package com.erzhan.bishkek.adapters

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.erzhan.bishkek.R
import com.erzhan.bishkek.data.Place

class PlaceAdapter(
    val myActivity: AppCompatActivity,
    var context: Context,
    var groupList: ArrayList<String>,
    var childList: HashMap<String, ArrayList<Place>>
) : BaseExpandableListAdapter() {

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var listView = convertView

        if (listView == null) {
            val inflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            listView = inflater.inflate(R.layout.list_group, null)
        }


        val placeName = listView!!.findViewById<TextView>(R.id.nameTextViewId)
        placeName!!.text = getGroup(groupPosition) as CharSequence?

        val place: Place? = getChild(groupPosition, groupPosition)

        val placeDistrict = listView.findViewById<TextView>(R.id.districtTextViewId)
        placeDistrict.text = place?.district;

        val placeImage = listView.findViewById<ImageView>(R.id.placeImageId)

        Glide
            .with(context)
            .load(place!!.imageResourceId)
            .placeholder(R.drawable.image_placeholder)
            .into(placeImage)

        return listView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        var listView = convertView

        if (listView == null) {
            val inflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            listView = inflater.inflate(R.layout.list_item, null)
        }

        val place: Place? = getChild(groupPosition, groupPosition)

        // Description logic

        val placeDescription = listView?.findViewById<TextView>(R.id.placeDescriptionTextView)
        placeDescription!!.text = place!!.description

        // Location logic

        val placeLocation = listView?.findViewById<TextView>(R.id.placeLocationTextViewId)
        placeLocation!!.text = place.location

        val mapLocal = place.mapLocation
        placeLocation.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$mapLocal?z=100"))
            val chooser = Intent.createChooser(intent, "Choose the app")
            try {
                context.startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    "Could find the app to open location",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Phone logic

        val placePhoneNumber = listView?.findViewById<TextView>(R.id.placePhoneTextView)
        val phoneLinearLayout =
            listView?.findViewById<LinearLayout>(R.id.placePhoneLinearLayout)

        if (place.hasPhone()) {
            val phoneNumber = place.phoneNumber.trim()
            placePhoneNumber!!.text = phoneNumber

            placePhoneNumber.setOnClickListener {

                try {
                    if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(myActivity, arrayOf(android.Manifest.permission.CALL_PHONE),101);

                        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
                            try {
                                context.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                Toast.makeText(context,"Could find the app to call",Toast.LENGTH_LONG).show()
                            }
                        } else {
                            return@setOnClickListener
                        }
                    }

                    phoneCall(phoneNumber)

                } catch (e: Exception) {
                    Toast.makeText(context, "ERROR $e", Toast.LENGTH_SHORT).show()
                }

            }
        } else {
            if (phoneLinearLayout != null) {
                phoneLinearLayout.visibility = View.GONE
            }
        }

        return listView
    }

    private fun phoneCall(phoneNumber: String) {

        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Could find the app to call", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): Any {
        return groupList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Place? {
        return childList[groupList[groupPosition]]?.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }
}