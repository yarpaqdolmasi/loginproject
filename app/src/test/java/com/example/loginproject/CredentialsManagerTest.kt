package com.example.loginproject

import com.example.loginproject.data.CredentialsManager
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CredentialsManagerTest {

    // Test empty email
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }

    // Test wrong email format
    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("test")
        assertEquals(false, isEmailValid)
    }

    // Test proper email
    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("john.blair@example-pet-store.com")
        assertEquals(true, isEmailValid)
    }

    // Test empty password
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isPasswordValid("")
        assertEquals(false, isEmailValid)
    }

    // Test filled password
    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isPasswordValid("12345678")
        assertEquals(true, isEmailValid)
    }
}