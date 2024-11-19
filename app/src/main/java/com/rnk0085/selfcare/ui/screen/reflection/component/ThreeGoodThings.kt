package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

@Composable
internal fun ThreeGoodThings(
    goodThingItems: List<GoodThingItem>,
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

        goodThingItems.forEach { goodThingItem ->
            Spacer(modifier = Modifier.height(Spacing.Medium))

            GoodThingTextField(
                keyboardEvent = goodThingItem.keyboardEvent,
                placeHolderText = "美味しいご飯を食べた",
                value = goodThingItem.value,
                onValueChange = goodThingItem.onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.Small),
            )
        }
    }
}

data class GoodThingItem(
    val keyboardEvent: KeyboardEvent,
    val value: String,
    val onValueChange: (String) -> Unit,
)

@Composable
@Preview
private fun ThreeGoodThingsPreview() {
    SelfcareTheme {
        ThreeGoodThings(
            goodThingItems = listOf(
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Next(
                        onClick = {},
                    ),
                    value = "",
                    onValueChange = {},
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Next(
                        onClick = {},
                    ),
                    value = "",
                    onValueChange = {},
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Done(
                        onClick = {},
                    ),
                    value = "",
                    onValueChange = {},
                ),
            )
        )
    }
}
