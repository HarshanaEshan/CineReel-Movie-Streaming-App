package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var databaseHelper = DBHelper(applicationContext)
        var globalIndex = 0

        val buttoReg: Button = findViewById(R.id.i2buttonregister)
        val backButton:ImageButton = findViewById(R.id.iRegistrationBackButton)
        val btnLogIn:Button = findViewById(R.id.iRegistrationGoToLogIn)

        var firstName:EditText = findViewById(R.id.editTextFirstName)
        var lastName:EditText = findViewById(R.id.editTextLastName)
        var userName:EditText = findViewById(R.id.editTextUserName)
        var email:EditText = findViewById(R.id.editTextEmail)
        var password:EditText = findViewById(R.id.editTextPassword)
        var mobileNum:EditText = findViewById(R.id.editTextMobileNumber)

        buttoReg.setOnClickListener{
            var index = ++globalIndex

            val isInserted = databaseHelper.insertData(
                index.toString(),
                firstName.text.toString(),
                lastName.text.toString(),
                userName.text.toString(),
                email.text.toString(),
                password.text.toString(),
                mobileNum.text.toString()
            )

//            val bundle = Bundle()
//            bundle.putString("UserName",userName.text.toString())

            if (isInserted){
                Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()

                val signInScreen = Intent(applicationContext,MainActivity::class.java)
//                signInScreen.putExtras(bundle)
                startActivity(signInScreen)
            }else{
                Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        backButton.setOnClickListener{
            val goMainPage = Intent(applicationContext,MainActivity::class.java)
            startActivity(goMainPage)
        }

        btnLogIn.setOnClickListener{
            val goRegPage = Intent(applicationContext,Login::class.java)
            startActivity(goRegPage)
        }
    }
}