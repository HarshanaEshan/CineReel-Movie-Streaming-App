package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonClick:Button = findViewById(R.id.i1btnReg)
        buttonClick.setBackgroundColor(getColor(R.color.orange))
        val buttonLogIn:Button = findViewById(R.id.i1btnLogIn)
        buttonLogIn.setBackgroundColor(getColor(R.color.orange))

        buttonClick.setOnClickListener{
            val goToNextScreen = Intent(applicationContext,Registration::class.java)
            startActivity(goToNextScreen)
        }

        buttonLogIn.setOnClickListener{
            val goToLogInScreen = Intent(applicationContext,Login::class.java)
            startActivity(goToLogInScreen)
        }
    }
}