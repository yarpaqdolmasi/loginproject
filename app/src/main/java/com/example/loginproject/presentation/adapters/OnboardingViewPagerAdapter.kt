package com.example.loginproject.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingViewPagerAdapter(private val items: List<Fragment>, private val parentFragment: Fragment ): FragmentStateAdapter(parentFragment) {
    override fun getItemCount() = items.size

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

}