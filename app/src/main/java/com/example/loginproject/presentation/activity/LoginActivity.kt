package com.example.loginproject.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.loginproject.R
import com.example.loginproject.data.CredentialsManager
import com.example.loginproject.databinding.LoginActivityBinding
import com.example.loginproject.presentation.fragments.LoginFragment

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    var credentialsManager: CredentialsManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        credentialsManager = CredentialsManager()
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal)
        supportFragmentManager.beginTransaction().replace(R.id.fcvLogin, LoginFragment()).commit()
    }
}