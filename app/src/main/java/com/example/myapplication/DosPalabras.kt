package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
/*import androidx.core.view.WindowInsetsCompat*/
import com.google.android.material.bottomnavigation.BottomNavigationView

class DosPalabras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dos_palabras)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_mitades -> {
                    // Acción 1
                    true
                }
                R.id.nav_dos_palabras -> {
                    // Acción 2
                    true
                }
                R.id.nav_quitar -> {
                    // Acción 3
                    true
                }
                else -> false
            }
        }
    }
}