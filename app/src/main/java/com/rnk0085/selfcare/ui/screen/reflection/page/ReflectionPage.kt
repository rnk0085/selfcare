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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rnk0085.selfcare.R
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.component.PrimaryButton
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.GoodThingItem
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.KeyboardEvent
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodSelectorSection
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings.ThreeGoodThingsSection
import com.rnk0085.selfcare.ui.screen.reflection.section.diaryDatePicker.DiaryDatePickerSection
import com.rnk0085.selfcare.ui.theme.SelfcareTheme
import com.rnk0085.selfcare.ui.theme.Spacing

@Composable
internal fun ReflectionPage(
    onRecordClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedDate by remember { mutableLongStateOf(currentTimeMillis) }
    var showDatePicker by remember { mutableStateOf(false) }

    var selectedMood by remember { mutableStateOf<MoodType?>(null) }

    var firstText by remember { mutableStateOf("") }
    var secondText by remember { mutableStateOf("") }
    var thirdText by remember { mutableStateOf("") }

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
            onClick = { showDatePicker = true },
            onDismiss = { showDatePicker = false },
            onDateSelected = {
                selectedDate = it ?: currentTimeMillis
                showDatePicker = false
            },
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))

        MoodSelectorSection(
            selectedMood = selectedMood,
            onMoodSelected = { selectedMood = it },
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
                    onValueChange = { firstText = it },
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Next(
                        onClick = { focusManager.moveFocus(FocusDirection.Next) },
                    ),
                    placeHolderText = stringResource(R.string.good_thing_place_holder_text_second),
                    value = secondText,
                    onValueChange = { secondText = it },
                ),
                GoodThingItem(
                    keyboardEvent = KeyboardEvent.Done(
                        onClick = { focusManager.clearFocus() },
                    ),
                    placeHolderText = stringResource(R.string.good_thing_place_holder_text_third),
                    value = thirdText,
                    onValueChange = { thirdText = it },
                ),
            )
        )

        Spacer(modifier = Modifier.height(48.dp))

        PrimaryButton(
            text = stringResource(R.string.record_button_text),
            onClick = onRecordClick,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Preview
@Composable
private fun ReflectionPagePreview() {
    SelfcareTheme {
        ReflectionPage(
            onRecordClick = {},
        )
    }
}