package com.example.tictactoegame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var lottie:LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        textView = findViewById(R.id.TV_SP)
        lottie = findViewById(R.id.lottie)

        textView.animate().translationY(-1500F).setDuration(2700).startDelay = 0
        lottie.animate().translationX(2000F).setDuration(2000).startDelay = 2900


        Handler().postDelayed(object : Runnable {
            override fun run() {
                val i = Intent(applicationContext, AddPlayer::class.java)
                startActivity(i)
            }
        }, 5000)
    }
}