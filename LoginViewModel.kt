package com.capstone.petang.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.petang.data.AuthRepository
import com.capstone.petang.data.remote.response.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    /**
     * Do authentication for the users
     *
     * @param email User's email
     * @param password User's password
     * @return Flow
     */
    suspend fun userLogin(email: String, password: String): Flow<Result<LoginResponse>> =
        authRepository.userLogin(email, password)


    /**
     * Save user's authentication token
     *
     * @param token User's authentication token
     */
    fun saveAuthToken(token: String) {
        viewModelScope.launch {
            authRepository.saveAuthToken(token)
        }
    }
}