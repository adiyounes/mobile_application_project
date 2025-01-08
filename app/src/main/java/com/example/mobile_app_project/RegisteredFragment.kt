package com.example.mobile_app_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobile_app_project.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class RegisteredFragment : Fragment() {

    private lateinit var credentialsManager: CredentialsManager

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        val view = inflater.inflate(R.layout.frag_registered, container, false)

        // Initialize the CredentialsManager
        credentialsManager = CredentialsManager(requireContext())

        // Initialize UI elements
        val nameInput = view.findViewById<TextInputEditText>(R.id.fullNameInput)
        val emailInput = view.findViewById<TextInputEditText>(R.id.emailInput)
        val phoneInput = view.findViewById<TextInputEditText>(R.id.phoneInput)
        val passwordInput = view.findViewById<TextInputEditText>(R.id.passwordInput)
        val nextButton = view.findViewById<MaterialButton>(R.id.nextButton)
        val loginText = view.findViewById<MaterialTextView>(R.id.loginText)

        // Handle next button click
        nextButton.setOnClickListener {
            val fullName = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (isInputValid(fullName, email, phone, password)) {
                val result = credentialsManager.register(email, password)
                showToast(result)

                if (result == "Registration successful.") {
                    navigateToSignInFragment()
                }
            } else {
                showToast("All fields must be filled out.")
            }
        }

        // Handle login text click
        loginText.setOnClickListener {
            navigateToSignInFragment()
        }

        return view
    }

    // Check if all input fields are valid
    private fun isInputValid(fullName: String, email: String, phone: String, password: String): Boolean {
        return fullName.isNotBlank() && email.isNotBlank() && phone.isNotBlank() && password.isNotBlank()
    }

    // Navigate to the SignInFragment
    private fun navigateToSignInFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SignInFragment())
            .addToBackStack(null)
            .commit()
    }

    // Show a toast message
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
