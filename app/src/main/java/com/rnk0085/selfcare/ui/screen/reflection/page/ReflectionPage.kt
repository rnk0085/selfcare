package com.rnk0085.selfcare.ui.screen.reflection.page

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.screen.component.PrimaryButton
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.GoodThingItem
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.KeyboardEvent
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodSelectorSection
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.ThreeGoodThingsSection
import com.rnk0085.selfcare.ui.screen.reflection.section.diaryDatePicker.DiaryDatePickerSection
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.Spacing

@Composable
internal fun ReflectionPage(
    selectedDate: Long,
    showDatePicker: Boolean,
    selectedMood: MoodType?,
    firstText: String,
    secondText: String,
    thirdText: String,
    openDatePicker: () -> Unit,
    closeDatePicker: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    onMoodSelected: (MoodType) -> Unit,
    onFirstTextChange: (String) -> Unit,
    onSecondTextChange: (String) -> Unit,
    onThirdTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() },
                )
            }
            .verticalScroll(rememberScrollState())
            .padding(horizontal = Spacing.Large),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(Spacing.Medium))

        DiaryDatePickerSection(
            selectedDate = selectedDate,
            showDatePicker = showDatePicker,
            openDatePicker = openDatePicker,
            closeDatePicker = closeDatePicker,
            onDateSelected = onDateSelected,
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))

        MoodSelectorSection(
            selectedMood = selectedMood,
            onMoodSelected = onMoodSelected,
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))

        ThreeGoodThingsSection(
            goodThingItems = listOf(
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Next(
                        onClick = { focusManager.moveFocus(FocusDirection.Next) },
                    ),
                    placeHolderText = stringResource(R.string.good_thing_place_holder_text_first),
                    value = firstText,
                    onValueChange = onFirstTextChange,
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Next(
                        onClick = { focusManager.moveFocus(FocusDirection.Next) },
                    ),
                    placeHolderText = stringResource(R.string.good_thing_place_holder_text_second),
                    value = secondText,
                    onValueChange = onSecondTextChange,
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Done(
                        onClick = { focusManager.clearFocus() },
                    ),
                    placeHolderText = stringResource(R.string.good_thing_place_holder_text_third),
                    value = thirdText,
                    onValueChange = onThirdTextChange,
                ),
            )
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))
    }
}

@Preview
@Composable
private fun ReflectionPagePreview() {
    SelfcareTheme {
        ReflectionPage(
            selectedDate = 123456789,
            showDatePicker = false,
            selectedMood = MoodType.GOOD,
            firstText = "",
            secondText = "",
            thirdText = "",
            openDatePicker = {},
            closeDatePicker = {},
            onDateSelected = {},
            onMoodSelected = {},
            onFirstTextChange = {},
            onSecondTextChange = {},
            onThirdTextChange = {},
        )
    }
}
