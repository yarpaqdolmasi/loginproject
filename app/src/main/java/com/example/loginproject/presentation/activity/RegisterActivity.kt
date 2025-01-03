package com.example.loginproject.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginproject.R
import com.example.loginproject.databinding.RegisterActivityBinding
import com.example.loginproject.presentation.fragments.RegisterFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: RegisterActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fcvRegister, RegisterFragment()).commit()
    }
}