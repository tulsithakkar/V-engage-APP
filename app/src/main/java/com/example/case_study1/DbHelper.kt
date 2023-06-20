package com.example.case_study1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper(context,"case_data1",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        //p0?.execSQL("create table VEngage(id Text PRIMARY KEY ,pw Text)")
        p0?.execSQL("create table VEngage(Full_name Text , Address Text , DOB Text, Gender Text, Occupation Text,id Text PRIMARY KEY ,pw Text )")



    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("Drop Table If Exists VEngage")
        onCreate(p0)

    }
}