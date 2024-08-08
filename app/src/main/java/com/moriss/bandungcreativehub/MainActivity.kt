package com.moriss.bandungcreativehub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.btnKegi -> {
                    replaceFragment(Kegiatan())
                    true
                }
                R.id.btnFasi -> {
                    replaceFragment(Fasilitas())
                    true
                }
                R.id.btnUlasan -> {
                    replaceFragment(Ulasan())
                    true
                }
                else -> false
            }
        }
        replaceFragment(Kegiatan())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment) // Ensure this ID matches your layout XML
            .commit()
    }
}