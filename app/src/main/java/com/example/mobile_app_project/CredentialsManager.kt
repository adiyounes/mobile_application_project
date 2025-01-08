package com.example.mobile_app_project

import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns

class CredentialsManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("UserCredentials", Context.MODE_PRIVATE)
    private val credentialsMap: MutableMap<String, String> = mutableMapOf()

    init {
        sharedPreferences.all.forEach { entry ->
            val (key, value) = entry
            if (value is String) {
                credentialsMap[key] = value
            }
        }
    }

    fun isValidEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun register(email: String, password: String): String {
        val formattedEmail = email.trim().lowercase()

        if (credentialsMap.containsKey(formattedEmail)) {
            return "Email already exists."
        }

        credentialsMap[formattedEmail] = password
        sharedPreferences.edit().apply {
            putString(formattedEmail, password)
            apply()
        }

        return "Registration successful."
    }
}
