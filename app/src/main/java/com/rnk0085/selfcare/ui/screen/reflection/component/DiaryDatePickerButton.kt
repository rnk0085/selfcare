package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun DiaryDatePickerButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedDate by remember { mutableStateOf(System.currentTimeMillis()) }

    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onSurface,
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = convertMillisToDate(selectedDate),
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

private fun convertMillisToDate(millis: Long): String {
    val formater = SimpleDateFormat("yyyy/MM/dd(EEE)", Locale.getDefault())
    return formater.format(Date(millis))
}

@Composable
@Preview
private fun DiaryDatePickerButtonPreview() {
    DiaryDatePickerButton(
        onClick = {},
    )
}