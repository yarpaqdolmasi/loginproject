package com.example.loginproject.presentation.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginproject.R
import com.example.loginproject.core.CoreFragment
import com.example.loginproject.data.CredentialsManager
import com.example.loginproject.data.User
import com.example.loginproject.databinding.RegisterFragmentBinding
import com.example.loginproject.presentation.activity.LoginActivity

class RegisterFragment : CoreFragment(R.layout.register_fragment) {

    private lateinit var binding: RegisterFragmentBinding

    private var sharedPrefs: SharedPreferences? = null
    private var credentialsManager: CredentialsManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = activity?.getSharedPreferences(
            getString(R.string.shared_pref_name),
            Context.MODE_PRIVATE
        )
        credentialsManager = (activity as LoginActivity).credentialsManager

        initButtons()
    }

    private fun initButtons() = with(binding) {
        btnNext.setOnClickListener {
            val isEmailValid = isEmailValid(etEmail.text.toString().trim().lowercase())
            val isPasswordValid = isPasswordValid(etPassword.text.toString())
            if (isEmailValid) etEmail.error = null else etEmail.error = getString(R.string.invalid_email)
            if (isPasswordValid) etPassword.error = null else etPassword.error = getString(R.string.invalid_password)

            if (isEmailValid && isPasswordValid) {
                sharedPrefs?.let { sharedPrefs ->
                    val isRegistered = credentialsManager?.register(
                        User(
                            etEmail.text.toString().trim().lowercase(),
                            etPassword.text.toString(),
                        ),
                        sharedPrefs
                    )
                    if (isRegistered == true) {
                        Toast.makeText(context, getString(R.string.registered_successfully), Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(context, LoginActivity::class.java))
                    } else
                        etEmail.error = getString(R.string.already_registered)
                }
            }
        }

        tvLogIn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fcvLogin, LoginFragment())
                .commit()
        }
    }

    private fun isEmailValid(email: String) = CredentialsManager().isEmailValid(email)
    private fun isPasswordValid(password: String) = CredentialsManager().isPasswordValid(password)

}