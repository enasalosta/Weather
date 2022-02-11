package com.example.weather.view.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.weather.R
import com.example.weather.view.Home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashTimeOut = 2000
        val intent = Intent(this@SplashActivity, HomeActivity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, splashTimeOut.toLong())
    }
}