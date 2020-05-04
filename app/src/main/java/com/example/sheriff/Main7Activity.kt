package com.example.sheriff

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main5.*

class Main7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        mBtnDonate.setOnClickListener {

            var name_donate = mEdtNameDonate.text.toString()
            var phone_donate = mEdtPhoneDonate.text.toString()
            var county_donate = mEdtCountyDonate.text.toString()
            var village_donate = mEdtVillageDonate.text.toString()
            var goods_donate = mEdtGoodsDonate.text.toString()
            var pass_donate = mEdtPassDonate.text.toString()

            var time = System.currentTimeMillis()

            var progress = ProgressDialog(this)
            progress.setTitle("Saving")
            progress.setMessage("Please wait...")

            if (name_donate.isEmpty() or phone_donate.isEmpty() or county_donate.isEmpty() or village_donate.isEmpty() or goods_donate.isEmpty() or pass_donate.isEmpty()){
                Toast.makeText(this, "Please fill all the inputs", Toast.LENGTH_LONG).show()
            }else{
                var ref = FirebaseDatabase.getInstance().reference.child("Donors/$time")
                var data = Sell(name_donate,phone_donate,county_donate,village_donate,goods_donate,pass_donate)

                progress.show()
                ref.setValue(data).addOnCompleteListener { task ->
                    progress.dismiss()
                    if (task.isSuccessful){
                        mEdtNameDonate.setText(null)
                        mEdtPhoneDonate.setText(null)
                        mEdtCountyDonate.setText(null)
                        mEdtVillageDonate.setText(null)
                        mEdtGoodsDonate.setText(null)
                        mEdtPassDonate.setText(null)
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
