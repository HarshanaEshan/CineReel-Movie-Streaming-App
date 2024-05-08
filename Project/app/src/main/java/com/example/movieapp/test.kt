package com.example.movieapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userName = intent.getStringExtra("UserName")
        val uSerName = userName

        val db = DBHelper(applicationContext)

        var text:TextView = findViewById(R.id.textView1111)
        var button:Button = findViewById(R.id.button1111)

//        button.setOnClickListener{
//            if (uSerName!!.isEmpty()){
//                Toast.makeText(this.applicationContext,"Error",Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            val cursor = db.getData(uSerName)
//            var data:String? = null
//            if (cursor != null){
//                if (cursor.moveToNext()){
//                    data = (
//                            "userId: "+cursor.getString(0)+"\n"+
//                            " firstName "+cursor.getString(1)+"\n"+
//                            " lastName "+cursor.getString(2)+"\n"+
//                            " userName "+cursor.getString(3)+"\n"+
//                            " email "+cursor.getString(4)+"\n"+
//                            " password "+cursor.getString(5)+"\n"+
//                            " mobileNum "+cursor.getString(6))
//
//                }
//                text.text = data
//            } else{
//                text.text = "Error"
//            }
//        }

        button.setOnClickListener{
            if (uSerName!!.isEmpty()){
                Toast.makeText(this.applicationContext,"Error",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cursor = db.getData(uSerName)
            var data:String? = null
            if (cursor != null){
                if (cursor.moveToNext()){
//                    data = (
//                            "userId: "+cursor.getString(0)+"\n"+
//                                    " firstName "+cursor.getString(1)+"\n"+
//                                    " lastName "+cursor.getString(2)+"\n"+
//                                    " userName "+cursor.getString(3)+"\n"+
//                                    " email "+cursor.getString(4)+"\n"+
//                                    " password "+cursor.getString(5)+"\n"+
//                                    " mobileNum "+cursor.getString(6))
                    data = (cursor.getString(5))
                }
                text.text = data
            } else{
                text.text = "Error"
            }
        }

    }
}