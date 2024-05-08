package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class horrar_movie_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_horrar_movie_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton:ImageButton = findViewById(R.id.iHorrorBackButton)
        val btnView1:Button = findViewById(R.id.iHorrarView1)
        val btnView2:Button = findViewById(R.id.iHorrarView2)

        backButton.setOnClickListener{
            val goToHome = Intent(applicationContext,HomePage::class.java)
            startActivity(goToHome)
        }

        btnView1.setOnClickListener{
            val goViewBtn1 = Intent(applicationContext,movie_details_home_1::class.java)
            startActivity(goViewBtn1)
        }

        btnView2.setOnClickListener{
            val goViewBtn2 = Intent(applicationContext,movie_details_home_2::class.java)
            startActivity(goViewBtn2)
        }
    }
}