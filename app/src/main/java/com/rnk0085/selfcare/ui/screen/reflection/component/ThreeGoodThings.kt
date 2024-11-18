package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.Spacing
import com.rnk0085.selfcare.ui.theme.sectionContainerColor
import com.rnk0085.selfcare.ui.theme.sectionContentColor

@Composable
internal fun ThreeGoodThings(
    firstText: String,
    onFirstTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(Color.White)
            .padding(vertical = Spacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.three_good_things_label),
            style = MaterialTheme.typography.labelMedium,
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))

        GoodThingTextField(
            placeHolderText = "美味しいご飯を食べた",
            value = firstText,
            onValueChange = onFirstTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.Small),
        )
    }
}

@Composable
private fun GoodThingTextField(
    value: String,
    placeHolderText: String,
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
    )
}

@Composable
@Preview
private fun ThreeGoodThingsPreview() {
    SelfcareTheme {
        ThreeGoodThings(
            firstText = "",
            onFirstTextChange = {},
        )
    }
}
