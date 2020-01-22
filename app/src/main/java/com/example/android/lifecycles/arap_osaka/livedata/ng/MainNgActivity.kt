package com.example.android.lifecycles.arap_osaka.livedata.ng

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android.codelabs.lifecycle.R

class MainNgActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ng)
        navController = findNavController(R.id.nav_host_container)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

}
