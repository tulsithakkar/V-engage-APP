package com.example.case_study1

import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

     val Occupation:Array<String> = arrayOf("Select","Industry","Doctor","Teacher","police")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fname:EditText=findViewById(R.id.fname)
        var add:EditText=findViewById(R.id.add)
        var dob:EditText=findViewById(R.id.dob)
        var male:RadioButton=findViewById(R.id.rmale)
        var female:RadioButton=findViewById(R.id.rfemale)
        var btn:Button=findViewById(R.id.button)
        var id1:EditText=findViewById(R.id.txt_id)
        var pw1:EditText=findViewById(R.id.txt_pw)
        var sp:Spinner=findViewById(R.id.spinner)
        var occ:String=""
        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.select_dialog_item,Occupation)
        sp.setAdapter(adapter)
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              // Toast.makeText(this@MainActivity,Occupation[p2],Toast.LENGTH_LONG).show()
                occ= Occupation[p2]

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        var helper=DbHelper(applicationContext)
        var db:SQLiteDatabase = helper.readableDatabase
        var rs= db.rawQuery("Select * from VEngage", null)
        btn.setOnClickListener {

            if(fname.text.toString()=="" && add.text.toString()=="" && dob.text.toString()==""
                && id1.text.toString()==""&& pw1.text.toString()=="" &&(male.isChecked== false || female.isChecked==false))
            {
                Toast.makeText(this,"Enter all the data",Toast.LENGTH_LONG).show()
            }
            else
            {
                var cv= ContentValues()
                cv.put("Full_name",fname.text.toString())
                cv.put("Address",add.text.toString())
                cv.put("DOB",dob.text.toString())
                if(male.isChecked)
                {
                    cv.put("Gender","Male")
                }
                else if(female.isChecked)
                {
                    cv.put("Gender","Female")
                }
                cv.put("Occupation",occ.toString())
                cv.put("id",id1.text.toString())
                cv.put("pw",pw1.text.toString())
                db.insert("VEngage",null,cv)
                rs.requery()
                Toast.makeText(this,"data saved",Toast.LENGTH_LONG).show()
                var intent= Intent(this, login::class.java)
                intent.putExtra("id",id1.text.toString())
                intent.putExtra("pw",pw1.text.toString())
                startActivity(intent)
            }
        }





    }
    override fun onBackPressed() {

        val dialogBuilder= AlertDialog.Builder(this)
        dialogBuilder.setTitle("Message!!")
        dialogBuilder.setMessage("Are you sure you want to Exit ??")
        dialogBuilder.setPositiveButton("Yes" , {dialogInterface:DialogInterface,i:Int ->finishAffinity()})
        dialogBuilder.setNegativeButton("No",{dialogInterface:DialogInterface,i:Int->})

        dialogBuilder.show();

    }
}