package com.example.sheriff

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main5.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        mBtnSaveSell.setOnClickListener {

            var name_sell = mEdtNameSell.text.toString()
            var phone_sell = mEdtPhoneSell.text.toString()
            var county_sell = mEdtCountySell.text.toString()
            var village_sell = mEdtVillageSell.text.toString()
            var goods_sell = mEdtGoodsSell.text.toString()
            var pass_sell = mEdtPassSell.text.toString()

            var time = System.currentTimeMillis()

            var progress = ProgressDialog(this)
            progress.setTitle("Saving")
            progress.setMessage("Please wait...")

            if (name_sell.isEmpty() or phone_sell.isEmpty() or county_sell.isEmpty() or village_sell.isEmpty() or goods_sell.isEmpty() or pass_sell.isEmpty()){
                Toast.makeText(this, "Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                var ref = FirebaseDatabase.getInstance().reference.child("Sellers/$time")
                var data = Sell(name_sell,phone_sell,county_sell,village_sell,goods_sell,pass_sell)

                progress.show()
                ref.setValue(data).addOnCompleteListener { task ->
                    progress.dismiss()
                    if (task.isSuccessful){
                        mEdtNameSell.setText(null)
                        mEdtPhoneSell.setText(null)
                        mEdtCountySell.setText(null)
                        mEdtVillageSell.setText(null)
                        mEdtGoodsSell.setText(null)
                        mEdtPassSell.setText(null)
                        startActivity(Intent(this,Main8Activity::class.java))
                        Toast.makeText(this, "Saving Successful", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Saving failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }
}
