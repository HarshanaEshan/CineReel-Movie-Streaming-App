package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uSErName:EditText = findViewById(R.id.editTextUserName)
        val pASsword:EditText = findViewById(R.id.editTextPassword)
        val btnLogIn: Button = findViewById(R.id.iLoginBtnLogIn)
        val btnBack:ImageButton = findViewById(R.id.iLogInBackBtn)
        val btnGoReg:Button = findViewById(R.id.iLogInGoRegBtn)

        val db = DBHelper(applicationContext)

        btnLogIn.setOnClickListener{
            if (uSErName.text.toString().isEmpty()){
                Toast.makeText(this.applicationContext,"Enter User Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if(pASsword.text.toString().isEmpty()){
                Toast.makeText(this.applicationContext,"Enter Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val cursor = db.getData(uSErName.text.toString())
                var getPass:String? = null
                if (cursor != null){
                    if (cursor.moveToNext()){
                        getPass = (cursor.getString(5))
                    }

                    if(pASsword.text.toString() == getPass){

                        val bundleFromLogIn = Bundle()
                        bundleFromLogIn.putString("UserNameFromLogIn",uSErName.text.toString())

                        Toast.makeText(this.applicationContext,"Log In Successful", Toast.LENGTH_SHORT).show()
                        val goToHomePage = Intent(applicationContext,HomePage::class.java)
                        goToHomePage.putExtras(bundleFromLogIn)
                        startActivity(goToHomePage)
                    }else{
                        Toast.makeText(this.applicationContext,"Log In Faill!!", Toast.LENGTH_SHORT).show()
                    }
                } else{
                    Toast.makeText(this.applicationContext,"Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnBack.setOnClickListener{
            val goMainPage = Intent(applicationContext,MainActivity::class.java)
            startActivity(goMainPage)
        }

        btnGoReg.setOnClickListener{
            val regPage = Intent(applicationContext,Registration::class.java)
            startActivity(regPage)
        }
    }
}