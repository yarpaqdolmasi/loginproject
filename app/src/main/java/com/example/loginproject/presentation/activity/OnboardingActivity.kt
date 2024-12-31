package com.example.loginproject.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onboardingproject.R
import com.example.onboardingproject.databinding.OnboardingActivityBinding
import com.example.loginproject.presentation.fragments.SplashFragment

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: OnboardingActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OnboardingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = SplashFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fcvOnboarding, fragment)
                .commit()
        }

    }

}