package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun ValidationText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.error,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ValidationTextPreview() {
    SelfcareTheme {
        ValidationText(
            text = "Validation text",
        )
    }
}
