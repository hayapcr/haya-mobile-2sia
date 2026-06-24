package com.example.haya_sparkle

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.Pertemuan11.OnBoardingActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(
                Intent(
                    this,
                    OnBoardingActivity::class.java
                )
            )

            finish()

        }, 2000)
    }
}