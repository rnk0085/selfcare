package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun ErrorDialog(
    message: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.error_dialog_title),
            )
        },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(R.string.ok))
            }
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ErrorDialogPreview() {
    SelfcareTheme {
        ErrorDialog(
            message = "エラー内容エラー内容エラー内容エラー内容エラー内容エラー内容エラー内容",
            onDismiss = {},
        )
    }
}
