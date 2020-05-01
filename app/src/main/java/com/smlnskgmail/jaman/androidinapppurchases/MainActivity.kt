package com.smlnskgmail.jaman.androidinapppurchases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smlnskgmail.jaman.androidinapppurchases.view.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showProfileFragment()
    }

    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction().let {
            it.add(
                android.R.id.content,
                ProfileFragment()
            )
            it.commit()
        }
    }

}
