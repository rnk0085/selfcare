package com.rnk0085.selfcare.ui.screen.reflection.section.diaryDatePicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun DiaryDatePickerSection(
    selectedDate: Long,
    showDatePicker: Boolean,
    openDatePicker: () -> Unit,
    closeDatePicker: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    modifier: Modifier = Modifier,
) {
    DiaryDatePickerButton(
        selectedDate = selectedDate,
        onClick = openDatePicker,
        modifier = modifier,
    )

    if (showDatePicker) {
        DatePickerModal(
            onDateSelected = onDateSelected,
            onDismiss = closeDatePicker,
        )
    }
}

@Preview
@Composable
private fun DiaryDatePickerSectionPreview() {
    SelfcareTheme {
        DiaryDatePickerSection(
            selectedDate = 123456789,
            showDatePicker = false,
            openDatePicker = {},
            closeDatePicker = {},
            onDateSelected = {},
        )
    }
}