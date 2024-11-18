package com.rnk0085.selfcare.ui.screen.reflection.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.Spacing

@Composable
internal fun MoodRadioGroup(
    selectedMood: MoodType?,
    onMoodSelected: (MoodType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(Color.White)
            .padding(all = Spacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
       Text(
           text = "どのような1日でしたか？",
           style = MaterialTheme.typography.labelMedium,
       )

        Spacer(modifier = Modifier.height(Spacing.Small))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            MoodType.entries.forEach { mood ->
                MoodIconButton(
                    moodType = mood,
                    isSelected = mood == selectedMood,
                    onClick = { onMoodSelected(mood) },
                )
            }
        }
    }
}

enum class MoodType(val resourceId: Int) {
    VERY_GOOD(R.drawable.baseline_sentiment_very_satisfied),
    GOOD(R.drawable.baseline_sentiment_satisfied_alt),
    NORMAL(R.drawable.baseline_sentiment_neutral),
    BAD(R.drawable.baseline_sentiment_dissatisfied),
    VERY_BAD(R.drawable.baseline_sentiment_very_dissatisfied),
}

@Composable
private fun MoodIconButton(
    moodType: MoodType,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val iconColor = if (isSelected) Color.Black else Color.LightGray

    IconButton(onClick) {
        Icon(
            painter = painterResource(moodType.resourceId),
            contentDescription = null,
            tint = iconColor,
        )
    }
}

@Preview
@Composable
private fun MoodRadioGroupPreview() {
    SelfcareTheme {
        MoodRadioGroup(
            selectedMood = MoodType.GOOD,
            onMoodSelected = {},
        )
    }
}
