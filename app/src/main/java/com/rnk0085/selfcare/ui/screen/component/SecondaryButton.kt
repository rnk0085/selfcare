package com.rnk0085.selfcare.ui.screen.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onSecondary,
            containerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.38f),
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
        ),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Composable
@Preview
private fun SecondaryButton() {
    SelfcareTheme {
        SecondaryButton(
            text = "Preview",
            onClick = {},
        )
    }
}

@Composable
@Preview
private fun SecondaryDisableButton() {
    SelfcareTheme {
        SecondaryButton(
            text = "Preview",
            onClick = {},
            enabled = false,
        )
    }
}
