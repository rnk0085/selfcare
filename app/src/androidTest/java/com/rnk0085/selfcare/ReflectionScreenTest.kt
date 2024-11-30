package com.rnk0085.selfcare

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.reflection.RecordState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionUiState
import com.rnk0085.selfcare.ui.screen.reflection.screen.ReflectionScreen
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import org.junit.Rule
import org.junit.Test

class ReflectionScreenTest {
    @get:Rule
    val composableTest = createComposeRule()

    @Test
    fun recordButton_whenInitialState_isDisable() {
        // 初期状態のとき
        composableTest.setContent {
            ReflectionScreen(
                uiState = ReflectionUiState.InitialValue,
                openDatePicker = {},
                closeDatePicker = {},
                onDateSelected = {},
                onMoodSelected = {},
                onFirstTextChange = {},
                onSecondTextChange = {},
                onThirdTextChange = {},
                onBackClicked = {},
                onRecordClick = {},
                resetRecordState = {},
            )
        }
        // 記録ボタンが無効か
        composableTest
            .onNodeWithTag("ReflectionScreen:recordButton")
            .assertIsNotEnabled()
    }

    @Test
    fun recordButton_whenAllFieldsFilled_isEnabled() {
        // 気分と 3 good things が入力されているとき
        val fakeUiState = ReflectionUiState(
            selectedMood = MoodType.VERY_GOOD,
            firstText = "First text",
            secondText = "Second text",
            thirdText = "Third text",
            recordState = RecordState.Idle,
            selectedDate = currentTimeMillis,
            showDatePicker = false,
        )

        composableTest.setContent {
            ReflectionScreen(
                uiState = fakeUiState,
                openDatePicker = {},
                closeDatePicker = {},
                onDateSelected = {},
                onMoodSelected = {},
                onFirstTextChange = {},
                onSecondTextChange = {},
                onThirdTextChange = {},
                onBackClicked = {},
                onRecordClick = {},
                resetRecordState = {},
            )
        }
        // 記録ボタンが有効か
        composableTest
            .onNodeWithTag("ReflectionScreen:recordButton")
            .assertIsEnabled()
    }
}