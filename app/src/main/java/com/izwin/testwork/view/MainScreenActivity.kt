package com.izwin.testwork.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.izwin.testwork.R
import kotlinx.android.synthetic.main.activity_payments.*

class MainScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_cont, PaymentsFragment())
            .commit()

        bottom_nav.setOnNavigationItemSelectedListener { item ->
            var fragment = Fragment()
            when (item.itemId) {
                R.id.nav_main -> {
                    fragment = PaymentsFragment()
                }
                R.id.nav_profile -> {
                    fragment = ProfileFragment()
                }
            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_cont, fragment)
                .commit()

            true
        }

    }
}