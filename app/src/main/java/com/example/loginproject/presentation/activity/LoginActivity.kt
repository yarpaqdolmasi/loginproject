package com.example.loginproject.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginproject.R
import com.example.loginproject.databinding.LoginActivityBinding
import com.example.loginproject.presentation.fragments.LoginFragment

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fcvLogin, LoginFragment()).commit()
    }
}