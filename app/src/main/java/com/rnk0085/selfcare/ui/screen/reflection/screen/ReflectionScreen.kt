package com.rnk0085.selfcare.ui.screen.reflection.screen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.PrimaryButton
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar
import com.rnk0085.selfcare.ui.screen.reflection.RecordState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionUiState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionViewModel
import com.rnk0085.selfcare.ui.screen.reflection.component.ErrorDialog
import com.rnk0085.selfcare.ui.screen.reflection.page.ReflectionPage
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import com.rnk0085.selfcare.ui.theme.Spacing

@Composable
internal fun ReflectionScreen(
    viewModel: ReflectionViewModel = hiltViewModel(),
    onBackClicked: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.recordState) {
        Log.d(TAG, "recordState: ${uiState.recordState}")
        if (uiState.recordState is RecordState.Success) {
            onBackClicked()
        }
    }

    ReflectionScreen(
        uiState = uiState,
        onBackClicked = onBackClicked,
        openDatePicker = viewModel::openDatePicker,
        closeDatePicker = viewModel::closeDatePicker,
        onDateSelected = viewModel::onDateSelected,
        onMoodSelected = viewModel::onMoodSelected,
        onFirstTextChange = viewModel::onFirstTextChange,
        onSecondTextChange = viewModel::onSecondTextChange,
        onThirdTextChange = viewModel::onThirdTextChange,
        onRecordClick = viewModel::onRecordClick,
        resetRecordState = viewModel::resetRecordState,
    )
}

@Composable
private fun ReflectionScreen(
    uiState: ReflectionUiState,
    onBackClicked: () -> Unit,
    openDatePicker: () -> Unit,
    closeDatePicker: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    onMoodSelected: (MoodType) -> Unit,
    onFirstTextChange: (String) -> Unit,
    onSecondTextChange: (String) -> Unit,
    onThirdTextChange: (String) -> Unit,
    onRecordClick: () -> Unit,
    resetRecordState: () -> Unit,
) {
    Scaffold(
        topBar = {
            SelfcareTopAppBar(
                title = stringResource(R.string.reflection_top_bar_title),
                navigationType = NavigationType.Back(onClick = onBackClicked),
            )
        },
        bottomBar = {
            BottomAppBar {
                PrimaryButton(
                    text = stringResource(R.string.record_button_text),
                    onClick = onRecordClick,
                    enabled = uiState.selectedMood != null
                            && uiState.firstText.isNotEmpty()
                            && uiState.secondText.isNotEmpty()
                            && uiState.thirdText.isNotEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Spacing.Large),
                )
            }
        },
    ) { innerPadding ->
        ReflectionPage(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            selectedDate = uiState.selectedDate,
            showDatePicker = uiState.showDatePicker,
            selectedMood = uiState.selectedMood,
            firstText = uiState.firstText,
            secondText = uiState.secondText,
            thirdText = uiState.thirdText,
            openDatePicker = openDatePicker,
            closeDatePicker = closeDatePicker,
            onDateSelected = onDateSelected,
            onMoodSelected = onMoodSelected,
            onFirstTextChange = onFirstTextChange,
            onSecondTextChange = onSecondTextChange,
            onThirdTextChange = onThirdTextChange,
        )

        if (uiState.recordState is RecordState.Loading) {
            // TODO: Loading 中は変更不可にする
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        if (uiState.recordState is RecordState.Error) {
            ErrorDialog(
                message = uiState.recordState.message,
                onDismiss = resetRecordState,
            )
        }
    }
}

@Composable
@Preview
private fun ReflectionScreenPreview() {
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
