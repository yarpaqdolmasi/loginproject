package com.example.loginproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.data.CredentialsManager
import com.example.loginproject.databinding.LoginFragmentBinding

class LoginFragment : CoreFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initButtons() {
        binding.btnNext.setOnClickListener {

        }
    }

    private fun isEmailValid(email: String) = CredentialsManager().isEmailValid(email)
}