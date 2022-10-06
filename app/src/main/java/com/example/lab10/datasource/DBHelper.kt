package com.example.lab10.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(
    context,
    "localdb.db",
    null,
    1
) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val orden = "CREATE TABLE usuarios " + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, correo TEXT, passw TEXT)"
        p0!!.execSQL(orden)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val borrar = "DROP TABLE IF EXISTS usuarios"
        p0!!.execSQL(borrar)
        onCreate(p0)
    }
}