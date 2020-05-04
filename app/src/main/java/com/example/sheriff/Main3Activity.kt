package com.example.sheriff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.activity_main6.*
import kotlinx.android.synthetic.main.activity_main6.mBtnSaveVehicle

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

       mBtnBuyGood.setOnClickListener {
           intent = Intent(this,Main4Activity::class.java)
           startActivity(intent)
       }

        mBtnDonateGoods.setOnClickListener {
            intent = Intent(this,Main7Activity::class.java)
            startActivity(intent)
        }

        mBtnSaleGoods.setOnClickListener {
            intent = Intent(this,Main5Activity::class.java)
            startActivity(intent)
        }
    }
}
