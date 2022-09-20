package com.example.lab9.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.lab9.R
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // R.id.FragmentContainer_MainAct
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer_MainAct) as NavHostFragment
        navController = navHostFragment.navController
        val appbarconfig = AppBarConfiguration(navController.graph)
        toolbar = findViewById(R.id.toolbar_MainAct)
        toolbar.setupWithNavController(navController, appbarconfig)
        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.charactersFragment -> {
                    toolbar.visibility = View.VISIBLE
                    true
                }
                R.id.fragment_CharacterDetail ->{
                    toolbar.menu.getItem(R.id.sortAz).isVisible = false
                    toolbar.menu.getItem(R.id.sortZa).isVisible = false
                    true
                }
                else->false
            }
        }
    }
}