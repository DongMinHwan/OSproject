package com.example.totalproject.web

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.totalproject.R

class web_MainListAdapter (val context: Context, val domainList: ArrayList<web_Domain>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.web_urllist, null)

        val domainName = view.findViewById<TextView>(R.id.doMainName)
        val domainAddress = view.findViewById<TextView>(R.id.doMainAddress)
        val domainExplan = view.findViewById<TextView>(R.id.domainExplan)

        val domain = domainList[position]
        domainName.text = domain.name
        domainAddress.text = domain.address
        domainExplan.text = domain.explan



        return view
    }

    override fun getCount(): Int {
        return domainList.size
    }

    override fun getItem(position: Int): Any {
        return domainList[position]
    }

    override fun getItemId(position: Int): Long {
        return  0
    }


}