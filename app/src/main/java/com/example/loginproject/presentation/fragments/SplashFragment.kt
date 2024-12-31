package com.example.loginproject.presentation.fragments

import android.os.Bundle
import android.view.View
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : CoreFragment(R.layout.splash_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delayFun(1000L)
    }

    private fun delayFun(time: Long) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(time)
            val fragment = LoginFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fcvOnboarding, fragment)?.commit()
        }
    }
}