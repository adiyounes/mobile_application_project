package com.example.mobile_app_project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobile_app_project.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignInFragment : Fragment() {

    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var nextButton: MaterialButton
    private lateinit var registered: MaterialTextView
    private lateinit var termsCheckbox: CheckBox
    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_sign_in, container, false)

        initializeViews(view)

        credentialsManager = CredentialsManager(requireContext())

        registered.setOnClickListener {
            navigateToRegisteredFragment()
        }

        nextButton.setOnClickListener {
            handleSignIn()
        }

        return view
    }

    private fun initializeViews(view: View) {
        emailInputLayout = view.findViewById(R.id.tilEmail)
        passwordInputLayout = view.findViewById(R.id.tilPassword)
        emailEditText = view.findViewById(R.id.emailInput)
        passwordEditText = view.findViewById(R.id.passwordInput)
        nextButton = view.findViewById(R.id.nextButton)
        termsCheckbox = view.findViewById(R.id.termsCheckbox)
        registered = view.findViewById(R.id.loginText)
    }

    private fun handleSignIn() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (isCredentialsValid(email, password)) {
            if (email.equals("test@te.st", ignoreCase = true) && password == "1234") {
                navigateToMainRecipeActivity()
            } else {
                showError("Invalid email or password. Please try again.")
            }
        }
    }

    private fun isCredentialsValid(email: String, password: String): Boolean {
        var isValid = true

        if (!credentialsManager.isValidEmail(email)) {
            emailInputLayout.error = "Invalid email format"
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            passwordInputLayout.error = "Password cannot be empty"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        return isValid
    }

    private fun navigateToMainRecipeActivity() {
        val intent = Intent(activity, MainRecipeActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    private fun navigateToRegisteredFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, RegisteredFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
