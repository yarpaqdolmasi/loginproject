package com.example.loginproject.presentation.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.data.CredentialsManager
import com.example.loginproject.data.User
import com.example.loginproject.databinding.LoginFragmentBinding
import com.example.loginproject.presentation.activity.RegisterActivity

class LoginFragment : CoreFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding

    private var credentialsManager = CredentialsManager()

    private var sharedPrefs: SharedPreferences? = null

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
        sharedPrefs = activity?.getSharedPreferences(
            getString(R.string.shared_pref_name),
            Context.MODE_PRIVATE
        )

        initButtons()
    }

    private fun initButtons() = with(binding) {
        btnNext.setOnClickListener {
            val email = etEmail.text.toString().trim().lowercase()
            val password = etPassword.text.toString()
            val isEmailValid = isEmailValid(email)
            val isPasswordValid = isPasswordValid(password)
            if (isEmailValid) {
                etEmail.error = null
            } else
                etEmail.error = "Invalid email"
            if (isPasswordValid) {
                etPassword.error = null
            } else
                etPassword.error = "Invalid password"
            if (isEmailValid && isPasswordValid) {
                sharedPrefs?.let {
                    val isPasswordCorrect = credentialsManager.login(User(email, password), it)

                    if (isPasswordCorrect) {
                        activity?.finish()
                    } else {
                        etPassword.error = "Wrong email or password"
                    }
                }
            }
        }

        tvRegisterNow.setOnClickListener {
            activity?.finish()
            val intent = Intent(context, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isEmailValid(email: String) = CredentialsManager().isEmailValid(email)

    private fun isPasswordValid(password: String) = CredentialsManager().isPasswordValid(password)
}