package com.rnk0085.selfcare.ui.screen.reflection.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionUiState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionViewModel
import com.rnk0085.selfcare.ui.screen.reflection.page.ReflectionPage
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType

@Composable
internal fun ReflectionScreen(
    viewModel: ReflectionViewModel = hiltViewModel(),
    onBackClicked: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
) {
    Scaffold(
        topBar = {
            SelfcareTopAppBar(
                title = stringResource(R.string.reflection_top_bar_title),
                navigationType = NavigationType.Back(onClick = onBackClicked),
            )
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
            onRecordClick = onRecordClick,
        )
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
    )
}
