package com.example.sheriff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWeb.loadUrl("file:///android_asset/home.html")
        Handler().postDelayed({
            intent = Intent(this,Main2Activity::class.java)
            startActivity(intent)
            finish()
        },6000)
    }
}
