package com.rnk0085.selfcare.ui.screen.reflection.page

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.rnk0085.selfcare.ui.screen.reflection.component.DatePickerModal
import com.rnk0085.selfcare.ui.screen.reflection.component.DiaryDatePickerButton
import com.rnk0085.selfcare.ui.screen.reflection.component.GoodThingItem
import com.rnk0085.selfcare.ui.screen.reflection.component.KeyboardEvent
import com.rnk0085.selfcare.ui.screen.reflection.component.MoodSelector
import com.rnk0085.selfcare.ui.screen.reflection.component.MoodType
import com.rnk0085.selfcare.ui.screen.reflection.component.ThreeGoodThings
import com.rnk0085.selfcare.ui.theme.SelfcareTheme

@Composable
internal fun ReflectionPage(
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
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DiaryDatePickerButton(
            selectedDate = selectedDate,
            onClick = { showDatePicker = true },
        )

        if (showDatePicker) {
            DatePickerModal(
                onDateSelected = {
                    selectedDate = it ?: currentTimeMillis
                    showDatePicker = false
                },
                onDismiss = { showDatePicker = false },
            )
        }

        MoodSelector(
            selectedMood = selectedMood,
            onMoodSelected = { selectedMood = it },
        )

        ThreeGoodThings(
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

        Button(onClick = { /* TODO */ }) {
            Text("記録する")
        }
    }
}

@Preview
@Composable
private fun ReflectionPagePreview() {
    SelfcareTheme {
        ReflectionPage()
    }
}