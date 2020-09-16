package com.example.totalproject.loginjoin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.totalproject.Login_MainActivity
import com.example.totalproject.R
import com.example.totalproject.Web_MainActivity
import com.example.totalproject.card.card_imageView
import com.example.totalproject.card_MainActivity
import kotlinx.android.synthetic.main.card_list.view.*
import kotlinx.android.synthetic.main.join.*

class Join_SubActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join)

        if(intent.hasExtra(("id"))) {

            JOIN_ID.setText(intent.getStringExtra("id"))
            JOIN_PW.setText(intent.getStringExtra("password"))
            JOIN_PW2.setText(intent.getStringExtra("password"))
        }

        join_cancle_button.setOnClickListener{
            val intent = Intent(this, Login_MainActivity::class.java)
           // println("intent" + Intent(this, Login_MainActivity::class.java))
            startActivity(intent)
        }

        confirm_buttion.setOnClickListener{
            val intent = Intent(this, card_MainActivity::class.java)

            print("intent : "+ Intent(this, card_MainActivity::class.java))
            startActivity(intent)
        }

        terms_button.setOnClickListener{
            val intent = Intent(this, Web_MainActivity::class.java)
          //print("intentterms"+ Intent(this, Web_MainActivity::class.java) )
            startActivity(intent)
        }



    }
}