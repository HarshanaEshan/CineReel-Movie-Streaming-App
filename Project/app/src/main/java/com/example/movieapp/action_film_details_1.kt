package com.example.movieapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class action_film_details_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_action_film_details1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backBtn:ImageButton = findViewById(R.id.iActionBackButton)

        val videoView = findViewById<VideoView>(R.id.video_view_1)
        val packageName = "android.resource://" + getPackageName() + "/" + R.raw.ex_2
        val uri = Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Optional: to loop the video
            mediaPlayer.start() // Start playing the video
        }

        backBtn.setOnClickListener{
            val goToHome = Intent(applicationContext,HomePage::class.java)
            startActivity(goToHome)
        }
    }
}