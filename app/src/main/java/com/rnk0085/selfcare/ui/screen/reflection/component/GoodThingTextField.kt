package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.sectionContainerColor
import com.rnk0085.selfcare.ui.theme.sectionContentColor

@Composable
internal fun GoodThingTextField(
    keyboardEvent: KeyboardEvent,
    placeHolderText: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        minLines = 3,
        maxLines = 5,
        modifier = modifier,
        placeholder = {
            Text(
                text = placeHolderText,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = sectionContentColor,
            focusedContainerColor = sectionContainerColor,
            focusedPlaceholderColor = Color.LightGray,
            unfocusedPlaceholderColor = Color.LightGray,
            focusedBorderColor = sectionContentColor,
            disabledBorderColor = Color.LightGray,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = when (keyboardEvent) {
                is KeyboardEvent.Next -> ImeAction.Next
                is KeyboardEvent.Done -> ImeAction.Done
            },
        ),
        keyboardActions = KeyboardActions(
            onNext = if (keyboardEvent is KeyboardEvent.Next) keyboardEvent.onClick else null,
            onDone = if (keyboardEvent is KeyboardEvent.Done) keyboardEvent.onClick else null,
        )
    )
}

sealed interface KeyboardEvent {
    val onClick: KeyboardActionScope.() -> Unit

    data class Next(override val onClick: KeyboardActionScope.() -> Unit) : KeyboardEvent

    data class Done(override val onClick: KeyboardActionScope.() -> Unit) : KeyboardEvent
}

@Composable
@Preview
private fun GoodThingTextFieldPreview() {
    SelfcareTheme {
        GoodThingTextField(
            keyboardEvent = KeyboardEvent.Done(
                onClick = {},
            ),
            placeHolderText = "placeHolderText",
            value = "",
            onValueChange = {},
        )
    }
}
