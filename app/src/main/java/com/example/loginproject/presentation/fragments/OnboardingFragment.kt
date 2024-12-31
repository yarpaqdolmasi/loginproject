package com.example.loginproject.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.presentation.adapters.OnboardingViewPagerAdapter

class OnboardingFragment: CoreFragment(R.layout.onboarding_fragment) {

    private val fragments = arrayListOf<Fragment>()
    val pagerAdapter by lazy {
        OnboardingViewPagerAdapter(fragments, this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initFragmentsList() {
        fragments.add(OnboardingItemFragment())
    }
}