package com.example.movieapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context) : SQLiteOpenHelper(context,"MovieDataBase1",null,1) {

    companion object{
        const val TABLE_NAME = "User"
        private const val SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (userId TEXT PRIMARY KEY, firstName TEXT, lastName TEXT, userName TEXT, email TEXT, password TEXT, mobileNum TEXT)"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertData(indexNo: String, firstName: String, lastName: String, userName: String, email: String, password: String, mobileNum: String):Boolean{
        val values = ContentValues().apply {
            put("userID",indexNo)
            put("firstName",firstName)
            put("lastName",lastName)
            put("userName",userName)
            put("email",email)
            put("password",password)
            put("mobileNum",mobileNum)
        }

        val db = this.writableDatabase
        val varResult = db.insert(TABLE_NAME,null,values)

//        values.put("userID",indexNo)
//        values.put("firstName",firstName)
//        values.put("lastName",lastName)
//        values.put("userName",userName)
//        values.put("email",email)
//        values.put("password",password)
//        values.put("mobileNum",mobileNum)
//        val db = this.writableDatabase
//        db.insert(TABLE_NAME,null,values)

        return varResult != -1L
    }

    fun getData(userNAME : String):Cursor{
        val dataBaseHelper = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE userName='$userNAME'"
        return dataBaseHelper.rawQuery(query,null)
    }
}