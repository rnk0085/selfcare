package com.rnk0085.selfcare.ui.screen.reflection

import androidx.lifecycle.ViewModel
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ReflectionViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ReflectionUiState.InitialValue)
    val uiState: StateFlow<ReflectionUiState> = _uiState.asStateFlow()

    fun onDateSelected(date: Long?) {
        _uiState.update {
            it.copy(
                selectedDate = date ?: currentTimeMillis,
                showDatePicker = false,
            )
        }
    }

    fun onMoodSelected(mood: MoodType) {
        _uiState.update {
            it.copy(
                selectedMood = mood,
            )
        }
    }

    fun openDatePicker() {
        _uiState.update {
            it.copy(
                showDatePicker = true,
            )
        }
    }

    fun closeDatePicker() {
        _uiState.update {
            it.copy(
                showDatePicker = false,
            )
        }
    }

    // TODO: firstText, secondText, thirdText の処理が同じなので共通化する
    fun onFirstTextChange(text: String) {
        _uiState.update {
            it.copy(
                firstText = text,
            )
        }
    }

    fun onSecondTextChange(text: String) {
        _uiState.update {
            it.copy(
                secondText = text,
            )
        }
    }

    fun onThirdTextChange(text: String) {
        _uiState.update {
            it.copy(
                thirdText = text,
            )
        }
    }
}