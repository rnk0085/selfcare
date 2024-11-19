package com.rnk0085.selfcare.ui.screen.reflection.section.diaryDatePicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun DiaryDatePickerSection(
    selectedDate: Long,
    showDatePicker: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    modifier: Modifier = Modifier,
) {
    DiaryDatePickerButton(
        selectedDate = selectedDate,
        onClick = onClick,
        modifier = modifier,
    )

    if (showDatePicker) {
        DatePickerModal(
            onDateSelected = onDateSelected,
            onDismiss = onDismiss,
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
            onClick = {},
            onDismiss = {},
            onDateSelected = {},
        )
    }
}