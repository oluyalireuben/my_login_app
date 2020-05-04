package com.example.sheriff

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main4.*


class Main2Activity : AppCompatActivity() {
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mBtnGo.setOnClickListener {
            intent = Intent(this,Main6Activity::class.java)
            startActivity(intent)
        }
       val loginBtn = findViewById<View>(R.id.mBtnSave) as Button

        loginBtn.setOnClickListener(View.OnClickListener {
            view -> login()
        })

        mBtnGo.setOnClickListener(View.OnClickListener {
            view -> register ()
        })
    }
    private fun login (){
        val emailTxt = findViewById<View>(R.id.mEdtMail) as EditText
        val passwordTxt = findViewById<View>(R.id.mEdtPass) as EditText

        var mail = mEdtMail.text.toString()
        var password = mEdtPass.text.toString()

        if (!mail.isEmpty() or !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful){
                    startActivity(Intent(this,Main8Activity::class.java))
                    Toast.makeText(this,"Successfully logged in",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                }
            })
        }else{
            Toast.makeText(this,"Please fill all the credentials",Toast.LENGTH_LONG).show()
        }
    }
    private fun register (){
        startActivity(Intent(this,Main6Activity::class.java))
    }
}
