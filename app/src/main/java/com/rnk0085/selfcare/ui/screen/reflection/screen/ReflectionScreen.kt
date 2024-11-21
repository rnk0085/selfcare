package com.rnk0085.selfcare.ui.screen.reflection.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.PrimaryButton
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar
import com.rnk0085.selfcare.ui.screen.reflection.page.ReflectionPage
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import com.rnk0085.selfcare.ui.theme.Spacing

@Composable
internal fun ReflectionScreen(
    onBackClicked: () -> Unit,
) {
    var selectedDate by remember { mutableLongStateOf(currentTimeMillis) }
    var showDatePicker by remember { mutableStateOf(false) }

    var selectedMood by remember { mutableStateOf<MoodType?>(null) }

    var firstText by remember { mutableStateOf("") }
    var secondText by remember { mutableStateOf("") }
    var thirdText by remember { mutableStateOf("") }

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
                    onClick = { /* TODO */ },
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
            selectedDate = selectedDate,
            showDatePicker = showDatePicker,
            selectedMood = selectedMood,
            firstText = firstText,
            secondText = secondText,
            thirdText = thirdText,
            openDatePicker = { showDatePicker = true },
            closeDatePicker = { showDatePicker = false },
            onDateSelected = {
                selectedDate = it ?: currentTimeMillis
                showDatePicker = false
            },
            onMoodSelected = { selectedMood = it },
            onFirstTextChange = { firstText = it },
            onSecondTextChange = { secondText = it },
            onThirdTextChange = { thirdText = it },
        )
    }
}

@Composable
@Preview
private fun ReflectionScreenPreview() {
    ReflectionScreen(
        onBackClicked = {},
    )
}
