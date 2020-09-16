package com.example.totalproject.card

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.totalproject.R
import org.json.JSONArray

class card_MainAdapter (val context: Context, val jArray : JSONArray) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.card_list2, null)
        val card_list = jArray[position]

//        var cardTitle = view.findViewById<TextView>(R.id.cardTitle)
//        val category = view.findViewById<TextView>(R.id.category)
//        val categoryDesc = view.findViewById<TextView>(R.id.categoryDesc)
//
//        cardTitle.text = jArray.getJSONObject(position).getString("avatarUrl")
//        category.text = jArray.getJSONObject(position).getString("category")
//        categoryDesc.text = jArray.getJSONObject(position).getString("categoryDesc")

        val cardTitle_01 = view.findViewById<TextView>(R.id.cardTitle_01)
        val category_01 = view.findViewById<TextView>(R.id.category_01)
        val categoryDesc_01 = view.findViewById<TextView>(R.id.categoryDesc_01)
        val img_01 = view.findViewById<ImageView>(R.id.listImage_01)

        val cardTitle_02 = view.findViewById<TextView>(R.id.cardTitle_02)
        val category_02 = view.findViewById<TextView>(R.id.category_02)
        val categoryDesc_02 = view.findViewById<TextView>(R.id.categoryDesc_02)
        val img_02 = view.findViewById<ImageView>(R.id.listImage_02)

        for(i in 0 until jArray.length()) {
            if(position % 2 == 0) {

                cardTitle_01.text = jArray.getJSONObject(position).getString("avatarUrl")
                category_01.text = jArray.getJSONObject(position).getString("category")
                categoryDesc_01.text = jArray.getJSONObject(position).getString("categoryDesc")
                val url_01 = jArray.getJSONObject(position).getString("avatarUrl")

                if(url_01 == "") {
                    Glide.with(context).load(R.drawable.android).into(img_01)
                }else{
                    Glide.with(context).load(url_01).into(img_01)
                }

            } else if(position % 2 == 1){
                cardTitle_02.text = jArray.getJSONObject(position).getString("avatarUrl")
                val url_02 = jArray.getJSONObject(position).getString("avatarUrl")
                category_02.text = jArray.getJSONObject(position).getString("category")
                categoryDesc_02.text = jArray.getJSONObject(position).getString("categoryDesc")

                if(url_02 == "") {
                    Glide.with(context).load(R.drawable.android).into(img_02)
                }else{
                    Glide.with(context).load(url_02).into(img_02)
                }
            }
        }


        return  view
    }

    override fun getCount(): Int {
        return jArray.length()
    }

    override fun getItem(position: Int): Any {
        return  jArray[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


}
