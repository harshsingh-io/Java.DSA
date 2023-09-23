package com.codeenemies.ecosync.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.codeenemies.ecosync.databinding.ActivitySplashBinding
import com.codeenemies.ecosync.firebase.FirestoreClass


class SplashActivity : AppCompatActivity() {
    private var binding:  ActivitySplashBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//        val typeFace: Typeface = Typeface.createFromAsset(assets, "charlie-display-bold.ttf")
//        binding?.tvAppName?.typeface = typeFace

        Handler().postDelayed({
            var currentUserID = FirestoreClass().getCurrentUserId()

            if (currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }
            else {
                startActivity(Intent(this, IntroActivity::class.java))
            }
            finish()
        }, 2500)
    }
}