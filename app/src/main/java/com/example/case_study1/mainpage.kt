package com.example.case_study1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class mainpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        var btn1:Button=findViewById(R.id.back)
        var btn2:Button=findViewById(R.id.Connect)

        btn1.setOnClickListener {
            var intent= Intent(this, homepage::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            Toast.makeText(this, "you are connected ",Toast.LENGTH_LONG).show()
        }


    }
    override fun onBackPressed() {
        var intent= Intent(this, homepage::class.java)
        startActivity(intent)
    }
}