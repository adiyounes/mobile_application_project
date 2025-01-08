package com.example.mobile_app_project

class CredentialsManagerTest {

    private lateinit var credentialsManager: CredentialsManager

    fun runTests() {
        testEmptyEmail()
        testInvalidEmailFormat()
        testValidEmailFormat()
        testEmptyPassword()
        testNonEmptyPassword()
    }

    private fun testEmptyEmail() {
        val email = ""
        if (credentialsManager.isValidEmail(email)) {
            println("testEmptyEmail failed: Empty email should be invalid.")
        } else {
            println("testEmptyEmail passed: Detected empty email as invalid.")
        }
    }

    private fun testInvalidEmailFormat() {
        val email = "not-an-email"
        if (credentialsManager.isValidEmail(email)) {
            println("testInvalidEmailFormat failed: Incorrect format email should be invalid.")
        } else {
            println("testInvalidEmailFormat passed: Detected invalid email format.")
        }
    }

    private fun testValidEmailFormat() {
        val email = "user@domain.com"
        if (credentialsManager.isValidEmail(email)) {
            println("testValidEmailFormat passed: Recognized valid email format.")
        } else {
            println("testValidEmailFormat failed: Valid email should be accepted.")
        }
    }

    private fun testEmptyPassword() {
        val password = ""
        if (credentialsManager.isValidPassword(password)) {
            println("testEmptyPassword failed: Empty password should be invalid.")
        } else {
            println("testEmptyPassword passed: Detected empty password as invalid.")
        }
    }

    private fun testNonEmptyPassword() {
        val password = "secure123"
        if (credentialsManager.isValidPassword(password)) {
            println("testNonEmptyPassword passed: Recognized non-empty password as valid.")
        } else {
            println("testNonEmptyPassword failed: Non-empty password should be accepted.")
        }
    }
}
