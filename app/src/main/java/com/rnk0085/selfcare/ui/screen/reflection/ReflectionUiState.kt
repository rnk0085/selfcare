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
) {
    companion object {
        val InitialValue = ReflectionUiState(
            selectedDate = currentTimeMillis,
            showDatePicker = false,
            selectedMood = null,
            firstText = "",
            secondText = "",
            thirdText = "",
        )
    }
}