package com.example.finalproject.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.finalproject.R
import com.example.finalproject.viewmodels.RequestViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: RequestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentHost) as NavHostFragment

        navController = navHostFragment.navController
        sharedViewModel = ViewModelProvider(this)[RequestViewModel::class.java]
        setupActionBarWithNavController(navController)
    }
}