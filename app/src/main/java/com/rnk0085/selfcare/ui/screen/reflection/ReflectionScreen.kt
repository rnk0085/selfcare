package com.rnk0085.selfcare.ui.screen.reflection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.component.NavigationType
import com.rnk0085.selfcare.ui.screen.component.SelfcareTopAppBar
import com.rnk0085.selfcare.ui.screen.reflection.component.DatePickerModal
import com.rnk0085.selfcare.ui.screen.reflection.component.DiaryDatePickerButton

@Composable
internal fun ReflectionScreen(
    onBackClicked: () -> Unit,
) {
    var selectedDate by remember { mutableLongStateOf(currentTimeMillis) }
    var showDatePicker by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SelfcareTopAppBar(
                title = "ふりかえり",
                navigationType = NavigationType.Back(onClick = onBackClicked),
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            DiaryDatePickerButton(
                selectedDate = selectedDate,
                onClick = { showDatePicker = true },
            )

            if (showDatePicker) {
                DatePickerModal(
                    onDateSelected = {
                        selectedDate = it ?: currentTimeMillis
                        showDatePicker = false
                    },
                    onDismiss = { showDatePicker = false },
                )
            }

            Button(onClick = { /* TODO */ }) {
                Text("記録する")
            }
        }
    }
}

@Composable
@Preview
private fun ReflectionScreenPreview() {
    ReflectionScreen(
        onBackClicked = {},
    )
}
