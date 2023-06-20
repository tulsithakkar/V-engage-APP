package com.example.case_study1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btn: Button =findViewById(R.id.btn_login)
        var id1:TextView=findViewById(R.id.txt_1)
        var pw1:TextView=findViewById(R.id.pw)
        var a= intent.getStringExtra("id")
        id1.setText(a)

        var b= intent.getStringExtra("pw")
        pw1.setText(b)
        btn.setOnClickListener {
            var intent= Intent(this, homepage::class.java)

            intent.putExtra("name",id1.text.toString())
            startActivity(intent)

        }
    }
    override fun onBackPressed() {
        var intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}