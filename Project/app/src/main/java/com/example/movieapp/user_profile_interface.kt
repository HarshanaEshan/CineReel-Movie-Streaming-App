package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class user_profile_interface : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile_interface)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = DBHelper(applicationContext)

        var showUserName:TextView = findViewById(R.id.iUserProfileUserName)
        var showFirstName:TextView = findViewById(R.id.iUserProfileFirstName)
        var showLastName:TextView = findViewById(R.id.iUserProfileLastName)
        var showEmail:TextView = findViewById(R.id.iUserProfileEmail)
        var showContact:TextView = findViewById(R.id.iUserProfileContact)

        var btnHome:Button = findViewById(R.id.btn_ui_home)
        var btnLogOut:Button = findViewById(R.id.btn_ui_logout)



        var btnUiHome: Button = findViewById(R.id.btn_ui_home)
        var btnUiLogout: Button = findViewById(R.id.btn_ui_logout)
        btnUiHome.setBackgroundColor(getColor(R.color.orange))
        btnUiLogout.setBackgroundColor(getColor(R.color.orange))

        var userNameForUserProfile = intent.getStringExtra("UserNameFromHome")

        if(userNameForUserProfile != null){
            val cursor = db.getData(userNameForUserProfile.toString())
            var firstNameFromDataBase:String? = null
            var lastNameFromDataBase:String? = null
            var emailFromDataBase:String? = null
            var contactNumberFromDataBase:String? = null


            if (cursor.moveToNext()){
                firstNameFromDataBase = (cursor.getString(1))
                lastNameFromDataBase = (cursor.getString(2))
                emailFromDataBase = (cursor.getString(4))
                contactNumberFromDataBase = (cursor.getString(6))
            }

            showUserName.text = userNameForUserProfile
            showFirstName.text = firstNameFromDataBase
            showLastName.text = lastNameFromDataBase
            showEmail.text = emailFromDataBase
            showContact.text = contactNumberFromDataBase
        }

        val btnGoToHomePage: ImageButton = findViewById(R.id.iUserProfileBackBtn)

        btnGoToHomePage.setOnClickListener{

            val goToHomePage = Intent(applicationContext,HomePage::class.java)
            startActivity(goToHomePage)
        }

        btnHome.setOnClickListener{
            val goToHomePagebtn = Intent(applicationContext,HomePage::class.java)
            startActivity(goToHomePagebtn)
        }

        btnLogOut.setOnClickListener{
            val goToMain = Intent(applicationContext,MainActivity::class.java)
            startActivity(goToMain)
        }
    }
}