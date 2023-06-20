package com.example.case_study1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        var alia:ImageButton=findViewById(R.id.im_aila)
        var ras:ImageButton=findViewById(R.id.im_ras)
        var kat:ImageButton=findViewById(R.id.im_kat)
        var deep:ImageButton=findViewById(R.id.im_deep)

        var nm:TextView=findViewById(R.id.name)

        var a= intent.getStringExtra("name")
        nm.setText(a)


        alia.setOnClickListener {
            var intent= Intent(this, mainpage::class.java)
            startActivity(intent)
        }
        ras.setOnClickListener {
            Toast.makeText(this, "no data available", Toast.LENGTH_LONG).show()

        }
        kat.setOnClickListener {
            Toast.makeText(this, "no data available", Toast.LENGTH_LONG).show()
        }
        deep.setOnClickListener {
            Toast.makeText(this, "no data available", Toast.LENGTH_LONG).show()
        }



    }
    override fun onBackPressed() {
        var intent= Intent(this, login::class.java)
        startActivity(intent)
    }
}