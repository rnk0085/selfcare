package com.rnk0085.selfcare.ui.screen.reflection

import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType

data class ReflectionUiState(
    val selectedDate: Long,
    val showDatePicker: Boolean,
    val selectedMood: MoodType?,
    val firstText: String,
    val secondText: String,
    val thirdText: String,
    val recordState: RecordState,
) {
    companion object {
        val InitialValue = ReflectionUiState(
            selectedDate = currentTimeMillis,
            showDatePicker = false,
            selectedMood = null,
            firstText = "",
            secondText = "",
            thirdText = "",
            recordState = RecordState.Idle,
        )
    }
}

sealed class RecordState {
    object Idle : RecordState()
    object Loading : RecordState()
    object Success : RecordState()
    data class Error(val message: String) : RecordState()
}
