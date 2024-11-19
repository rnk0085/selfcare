package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.theme.Spacing
import com.rnk0085.selfcare.ui.theme.sectionContainerColor
import com.rnk0085.selfcare.ui.theme.sectionContentColor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun DiaryDatePickerButton(
    selectedDate: Long,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            contentColor = sectionContentColor,
            containerColor = sectionContainerColor,
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
                modifier = Modifier.size(48.dp),
            )

            Spacer(modifier = Modifier.width(Spacing.Small))

            Text(
                text = convertMillisToDate(selectedDate),
                style = MaterialTheme.typography.headlineMedium,
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
        selectedDate = currentTimeMillis,
        onClick = {},
    )
}
