package com.example.loginproject.data

import android.content.SharedPreferences
import android.util.Log

class CredentialsManager {

    fun isEmailValid(email: String): Boolean {
        val isEmailValid = when {
            email.isNotEmpty() && email.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) -> true
            else -> false
        }
        return isEmailValid
    }

    fun isPasswordValid(password: String): Boolean {
        val isPasswordValid = when {
            password.isNotEmpty() && password.length >= 3 -> true
            else -> false
        }
        return isPasswordValid
    }

    fun register(emailAndPassword: User, sharedPreferences: SharedPreferences): Boolean {
        Log.d("testing", "register: ${emailAndPassword.email}")
        if (sharedPreferences.getString(emailAndPassword.email, null).isNullOrEmpty()) {
            sharedPreferences.edit().putString(emailAndPassword.email, emailAndPassword.password)
                .apply()
            return true
        } else {
            return false
        }
    }

    fun login(emailAndPassword: User, sharedPreferences: SharedPreferences): Boolean {
        val isPasswordCorrect = sharedPreferences.getString(emailAndPassword.email, null)?.let {
            it == emailAndPassword.password
        } ?: false
        return isPasswordCorrect
    }
}