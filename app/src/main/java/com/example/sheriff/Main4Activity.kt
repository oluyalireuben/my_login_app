package com.example.sheriff

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        mBtnSaveBuy.setOnClickListener {

            var name_buy = mEdtNameBuy.text.toString()
            var phone_buy = mEdtPhoneBuy.text.toString()
            var county_buy = mEdtCountyBuy.text.toString()
            var village_buy = mEdtVillageBuy.text.toString()
            var pass_buy = mEdtPassBuy.text.toString()

            var time = System.currentTimeMillis()

            var progress = ProgressDialog(this)
            progress.setTitle("Saving")
            progress.setMessage("Please wait...")

            if (name_buy.isEmpty() or phone_buy.isEmpty() or county_buy.isEmpty() or village_buy.isEmpty() or pass_buy.isEmpty()){
                Toast.makeText(this, "Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                var ref = FirebaseDatabase.getInstance().reference.child("Buyers/$time")
                var data = Buy(name_buy,phone_buy,county_buy,village_buy,pass_buy)

                progress.show()
                ref.setValue(data).addOnCompleteListener { task ->
                    progress.dismiss()
                    if (task.isSuccessful){
                        mEdtNameBuy.setText(null)
                        mEdtPhoneBuy.setText(null)
                        mEdtCountyBuy.setText(null)
                        mEdtVillageBuy.setText(null)
                        mEdtPassBuy.setText(null)
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
