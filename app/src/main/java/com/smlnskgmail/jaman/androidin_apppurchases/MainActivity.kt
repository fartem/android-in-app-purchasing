package com.smlnskgmail.jaman.androidin_apppurchases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smlnskgmail.jaman.androidin_apppurchases.view.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showProfileFragment()
    }

    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, ProfileFragment())
            .commit()
    }

}
