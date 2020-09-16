package com.example.totalproject.card

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.totalproject.R
import org.json.JSONArray

class card_imageView2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_imageviewhorizon)

        val actionbar = supportActionBar
        actionbar!!.title = ""

        // actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val img: ImageView = findViewById(R.id.imgViewhorizon)

        val url = intent.getStringExtra("cardTitle").toString()
        if(intent.hasExtra("cardTitle")) {
            val imgurl = url.toString()
            println("url : "+imgurl)
            Glide.with(this).load(imgurl).into(img)

            if(imgurl == ""){
                //Toast.makeText(this, "이미지가 없습니다.!", Toast.LENGTH_SHORT).show()
                Glide.with(this).load(R.drawable.android).into(img)
            }

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
