package com.vid90sec.videos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.vid90sec.videos.R

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup back button navigation
        val navController = findNavController(R.id.mainFragment)
        appBarConfig = AppBarConfiguration.Builder(navController.graph).build()
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.mainFragment).navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}
