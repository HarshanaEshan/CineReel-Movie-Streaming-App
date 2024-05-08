package com.example.movieapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var userNameFormHomePage = intent.getStringExtra("UserNameFromLogIn")

        val backButton:ImageButton = findViewById(R.id.iHomeBackButton)
        val actionBtn:Button = findViewById(R.id.btnCategory1)
        val horrorBtn:Button = findViewById(R.id.btnCategory2)
        val AnimationBtn:Button = findViewById(R.id.btnCategory3)
        val trillerBtn:Button = findViewById(R.id.btnCategory4)
        val btnView1:Button = findViewById(R.id.iHomeViewMore1)
        val btnView2:Button = findViewById(R.id.iHomeViewMore2)

        val videoView = findViewById<VideoView>(R.id.home_slider)
        val packageName = "android.resource://" + getPackageName() + "/" + R.raw.slider
        val uri = Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Optional: to loop the video
            mediaPlayer.start() // Start playing the video
        }

        var btnCategory1: Button = findViewById(R.id.btnCategory1)
        var btnCategory2: Button = findViewById(R.id.btnCategory2)
        var btnCategory3: Button = findViewById(R.id.btnCategory3)
        var btnCategory4: Button = findViewById(R.id.btnCategory4)
        val btnSeeUserProfile:ImageButton = findViewById(R.id.iHomeUserProfile)
        btnCategory1.setBackgroundColor(getColor(R.color.orange))
        btnCategory2.setBackgroundColor(getColor(R.color.orange))
        btnCategory3.setBackgroundColor(getColor(R.color.orange))
        btnCategory4.setBackgroundColor(getColor(R.color.orange))

        backButton.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this)

            alertDialogBuilder.setTitle("Alert!")
            alertDialogBuilder.setMessage("Do you want to exit?")
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("Yes"){_,_ -> finish()}
//            alertDialogBuilder.setNegativeButton("No"){_,_ ->
//                Toast.makeText(this,"Clicked No", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this,"Good", Toast.LENGTH_LONG).show()
//            }
            alertDialogBuilder.setNeutralButton("Cancel"){_,_ ->
//                Toast.makeText( this,"Clicked Cancel", Toast.LENGTH_SHORT).show()
            }
            val alertDialogBox = alertDialogBuilder.create()
            alertDialogBox.show()
        }

        btnSeeUserProfile.setOnClickListener{
            val bundleFromHomePage = Bundle()
            bundleFromHomePage.putString("UserNameFromHome",userNameFormHomePage.toString())

            val goToUserProfile = Intent(applicationContext,user_profile_interface::class.java)
            goToUserProfile.putExtras(bundleFromHomePage)
            startActivity(goToUserProfile)
        }

        actionBtn.setOnClickListener{
            val goActionList = Intent(applicationContext,action_film_list::class.java)
            startActivity(goActionList)
        }

        horrorBtn.setOnClickListener{
            val goHorrorList = Intent(applicationContext,horrar_movie_list::class.java)
            startActivity(goHorrorList)
        }

        AnimationBtn.setOnClickListener{
            val goComedyList = Intent(applicationContext,animetion_movie_list::class.java)
            startActivity(goComedyList)
        }

        trillerBtn.setOnClickListener{
            val goThrillerList = Intent(applicationContext,thriller_movie_list::class.java)
            startActivity(goThrillerList)
        }

        btnView1.setOnClickListener{
            val goToHomeMovie1 = Intent(applicationContext,movie_details_home_1::class.java)
            startActivity(goToHomeMovie1)
        }

        btnView2.setOnClickListener{
            val goToHomeMovie2 = Intent(applicationContext,movie_details_home_2::class.java)
            startActivity(goToHomeMovie2)
        }
    }
}