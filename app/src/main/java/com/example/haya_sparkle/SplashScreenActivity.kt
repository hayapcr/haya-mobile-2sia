package com.example.haya_sparkle

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.Pertemuan3.WelcomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPref = getSharedPreferences("DATA_LOGIN", MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({

            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {

                // MASUK KE HOME (BASEACTIVITY)
                startActivity(Intent(this, BaseActivity::class.java))

            } else {

                // KE HALAMAN LOGIN
                startActivity(Intent(this, WelcomeActivity::class.java))
            }

            finish()

        }, 2000)
    }
}