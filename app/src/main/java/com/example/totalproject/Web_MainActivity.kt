package com.example.totalproject

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.totalproject.R
import com.example.totalproject.loginjoin.Join_SubActivity
import com.example.totalproject.web.webActivity
import com.example.totalproject.web.web_Domain
import com.example.totalproject.web.web_MainListAdapter
import kotlinx.android.synthetic.main.web_activity_main.*
import kotlinx.android.synthetic.main.web_urllist.view.*
import kotlinx.android.synthetic.main.webview.*

class Web_MainActivity : AppCompatActivity() {

    var domainList = arrayListOf<web_Domain>(
        web_Domain("os컴퍼니스","https://www.osdew.com","오에스컴퍼니"),
        web_Domain("구글","https://www.google.com/","구글" ),
        web_Domain("네이버","https://m.naver.com","네이버" ),
        web_Domain("네이트","https://m.nate.com","네이트"),
        web_Domain("인스타그램","https://www.instagram.com/","인스타그램")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity_main)
//        val domainAdapter = MainListAdapter(this,domainList)
//        mainListView.adapter = domainAdapter
        mainListView.adapter = web_MainListAdapter(this,domainList)
        mainListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            var intent = Intent(this, webActivity::class.java)

            intent.putExtra("domain",view.doMainAddress.getText().toString())

            startActivity(intent)


            }


            back_button.setOnClickListener {
            var intent = Intent(this,Join_SubActivity::class.java)

            startActivity(intent)

        }



    }
    }
