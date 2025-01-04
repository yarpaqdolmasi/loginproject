package com.example.loginproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.data.OnboardingItem
import com.example.loginproject.databinding.OnboardingItemFragmentBinding

class OnboardingItemFragment(var item: OnboardingItem): CoreFragment(R.layout.onboarding_item_fragment) {
    private lateinit var binding: OnboardingItemFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = OnboardingItemFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPage()
    }

    private fun initPage() = with(binding){
        ivOnboardingImage.setImageResource(item.imgRes)
        tvTitle.text = item.title
        tvDescription.text = item.subtitle
    }
}