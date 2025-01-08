package com.example.mobile_app_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_app_project.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentification)

        // Load SignInFragment by default
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SignInFragment())
            .commit()
    }
}
