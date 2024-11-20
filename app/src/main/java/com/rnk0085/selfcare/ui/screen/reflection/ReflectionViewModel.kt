package com.rnk0085.selfcare.ui.screen.reflection

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class ReflectionViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ReflectionUiState.InitialValue)
    val uiState: StateFlow<ReflectionUiState> = _uiState.asStateFlow()
}