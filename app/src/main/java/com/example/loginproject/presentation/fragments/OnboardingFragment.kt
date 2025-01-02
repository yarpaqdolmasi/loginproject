package com.example.loginproject.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.data.OnboardingItem
import com.example.loginproject.databinding.OnboardingFragmentBinding
import com.example.loginproject.presentation.activity.LoginActivity
import com.example.loginproject.presentation.adapters.OnboardingViewPagerAdapter

class OnboardingFragment : CoreFragment(R.layout.onboarding_fragment) {

    private lateinit var binding: OnboardingFragmentBinding

    private val fragments = arrayListOf<Fragment>()
    private val pagerAdapter by lazy {
        OnboardingViewPagerAdapter(fragments, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OnboardingFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentsList()
        intiPager()
    }

    private fun initFragmentsList() {
        fragments.add(
            OnboardingItemFragment(
                OnboardingItem(
                    R.drawable.img_onboarding_1,
                    getString(R.string.onboarding_page_1_title),
                    getString(R.string.onboarding_page_1_description)
                )
            )
        )
        fragments.add(
            OnboardingItemFragment(
                OnboardingItem(
                    R.drawable.img_onboarding_2,
                    getString(R.string.onboarding_page_2_title),
                    getString(R.string.onboarding_page_2_description)
                )
            )
        )
        fragments.add(
            OnboardingItemFragment(
                OnboardingItem(
                    R.drawable.img_onboarding_3,
                    getString(R.string.onboarding_page_3_title),
                    getString(R.string.onboarding_page_3_description)
                )
            )
        )
    }

    private fun intiPager() = with(binding) {
        vpOnboardingPages.adapter = pagerAdapter
        ciIndicators.setViewPager(binding.vpOnboardingPages)
        btnNext.setOnClickListener {
            if (vpOnboardingPages.currentItem < fragments.size - 1)
                vpOnboardingPages.currentItem += 1
            else {
                val intent = Intent(activity, LoginActivity::class.java)
                activity?.startActivity(intent)
            }
        }
    }
}