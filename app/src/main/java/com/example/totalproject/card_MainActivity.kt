package com.example.totalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.totalproject.card.card_MainAdapter
import com.example.totalproject.card.card_imageView
import com.example.totalproject.card.card_imageView2
import kotlinx.android.synthetic.main.card_activity_main.*
import kotlinx.android.synthetic.main.card_list2.view.*
import org.json.JSONObject

class card_MainActivity : AppCompatActivity() {

    lateinit var request: RequestQueue
    lateinit var stringRequest: StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = ""

//        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        request = Volley.newRequestQueue(this)
        val url = "http://lara.osdew.com/api/dummy"
        // Setup RequestQueue

        stringRequest = StringRequest(Request.Method.GET, url, {

                response ->

            val cards = JSONObject(response)
            val jArray = cards.getJSONArray("cards")
            val cardAdapter = card_MainAdapter(this,jArray)
            listView.adapter = cardAdapter

            listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
                if(position % 2 == 0) {
                    var intent = Intent(this, card_imageView::class.java)

                    intent.putExtra("cardTitle", view.cardTitle_01.getText().toString())
                    startActivity(intent)

                    overridePendingTransition(R.anim.none2, R.anim.horizon_exit2)
                } else{
                    var intent = Intent(this, card_imageView2::class.java)

                    intent.putExtra("cardTitle", view.cardTitle_01.getText().toString())

                    startActivity(intent)

                    overridePendingTransition(R.anim.none2, R.anim.horizon_exit2)
                }

            }

        }, { error ->
            Log.i(applicationContext.packageName, error.toString()) // Print log if error occurred

        })

        // Set tag for cancel
        stringRequest.tag = applicationContext.packageName
        // Request
        request.add(stringRequest)
    }

    override fun onStop() {
        super.onStop()

        // Cancel all request that have packageName tag
        if(request != null) {
            request.cancelAll(applicationContext.packageName)
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        //onBackPressed()

        super.onBackPressed()

        overridePendingTransition(R.anim.horizon_exit2,R.anim.horizon_enter)

        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.horizon_exit2,R.anim.horizon_enter)
        //overridePendingTransition(R.anim.none,R.anim.horizon_exit)
    }
}