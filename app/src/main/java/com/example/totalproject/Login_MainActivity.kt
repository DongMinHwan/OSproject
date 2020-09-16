package com.example.totalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.totalproject.loginjoin.Join_SubActivity
import kotlinx.android.synthetic.main.loginjoin_activity_main.*

class Login_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginjoin_activity_main)

        JOIN_BUTTON.setOnClickListener{
            val intent = Intent(this, Join_SubActivity::class.java)
            intent.putExtra("id", LOGIN_ID.getText().toString())
            intent.putExtra("password", LOGIN_PW.getText().toString())

            startActivity(intent)
        }
    }
}