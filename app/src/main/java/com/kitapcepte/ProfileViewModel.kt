package com.kitapcepte

import androidx.lifecycle.ViewModel
import kotlinx.flow.MutableStateFlow
import kotlinx.flow.StateFlow

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Success)
    val uiState: StateFlow<ProfileUiState> = _uiState
}

sealed interface ProfileUiState {
    object Loading : ProfileUiState
    object Success : ProfileUiState
    data class Error(val message: String) : ProfileUiState
}

