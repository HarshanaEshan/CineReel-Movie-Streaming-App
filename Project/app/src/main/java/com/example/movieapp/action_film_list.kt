package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class action_film_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_action_film_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack:ImageButton = findViewById(R.id.iActionBackBtn)
        val viewBtn1:Button = findViewById(R.id.iActionView1)
        val viewBtn2:Button = findViewById(R.id.iActionView2)
        val viewBtn3:Button = findViewById(R.id.iActionView3)

        btnBack.setOnClickListener{
            val goToHome = Intent(applicationContext,HomePage::class.java)
            startActivity(goToHome)
        }

        viewBtn1.setOnClickListener{
            val goViewBtn1 = Intent(applicationContext,action_film_details_1::class.java)
            startActivity(goViewBtn1)
        }

        viewBtn2.setOnClickListener{
            val goViewBtn2 = Intent(applicationContext,action_film_details_2::class.java)
            startActivity(goViewBtn2)
        }

        viewBtn3.setOnClickListener{
            val goViewBtn3 = Intent(applicationContext,action_film_details_3::class.java)
            startActivity(goViewBtn3)
        }
    }
}