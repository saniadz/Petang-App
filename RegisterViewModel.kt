package com.capstone.petang.ui.register

import androidx.lifecycle.ViewModel
import com.capstone.petang.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    /**
     * Handle registration process for the users
     *
     * @param name User's name
     * @param email User's email
     *  @param phoneNumber User's phone_number
     * @param password User's password
     * @return Flow
     */
    suspend fun userRegister(name: String, email: String, phoneNumber: String, password: String) =
        authRepository.userRegister(name, email, phoneNumber, password)
}