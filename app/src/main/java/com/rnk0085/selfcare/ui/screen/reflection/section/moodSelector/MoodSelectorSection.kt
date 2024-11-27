package com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.screen.reflection.component.SectionTitleLabel
import com.rnk0085.selfcare.ui.screen.reflection.component.ValidationText
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.Spacing
import com.rnk0085.selfcare.ui.theme.sectionContainerColor

@Composable
internal fun MoodSelectorSection(
    selectedMood: MoodType?,
    onMoodSelected: (MoodType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(sectionContainerColor)
            .padding(all = Spacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionTitleLabel(
            text = stringResource(R.string.mood_selector_label),
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

        Spacer(modifier = Modifier.height(Spacing.Small))

        if (
            selectedMood == null
        ) {
            ValidationText(
                text = stringResource(R.string.mood_selector_validation_label),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.Small),
            )
        }
    }
}

@Preview
@Composable
private fun MoodRadioGroupPreview() {
    SelfcareTheme {
        MoodSelectorSection(
            selectedMood = MoodType.GOOD,
            onMoodSelected = {},
        )
    }
}
