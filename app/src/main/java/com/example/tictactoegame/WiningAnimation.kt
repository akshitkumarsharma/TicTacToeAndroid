package com.example.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView

class WiningAnimation : AppCompatActivity() {

    lateinit var lottie: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wining_animation)

        lottie = findViewById(R.id.lottieAnimation)

        lottie.animate().translationX(2000F).setDuration(2000).startDelay = 2900

        Handler().postDelayed(object : Runnable {
            override fun run() {
                this@WiningAnimation.finish()
            }
        }, 2600)
    }
}