package com.example.loginproject.data

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
}