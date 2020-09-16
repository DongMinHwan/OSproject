package com.example.totalproject.web

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.totalproject.R
import com.example.totalproject.Web_MainActivity
import com.example.totalproject.loginjoin.Join_SubActivity
import kotlinx.android.synthetic.main.web_activity_main.*
import kotlinx.android.synthetic.main.webview.*

class webActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        val webView: WebView = findViewById(R.id.main_webview)

        if (intent.hasExtra("domain")) {
            //main_webview.setText(intent.getStringExtra("domain"))

            intent.getStringExtra("domain")?.let { webView.loadUrl(it) }

        }

        webCancle_button.setOnClickListener {
            var intent = Intent(this, Web_MainActivity::class.java)

            startActivity(intent)
        }


    }
}