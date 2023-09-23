package com.codeenemies.ecosync.activities

import android.os.Bundle

import com.codeenemies.ecosync.databinding.ActivityMainBinding
import com.codeenemies.ecosync.firebase.FirestoreClass

class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        FirestoreClass().signInUser(this)
    }


}