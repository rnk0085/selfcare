package com.rnk0085.selfcare.ui.screen.reflection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Timestamp
import com.rnk0085.selfcare.data.DiaryRepository
import com.rnk0085.selfcare.domain.model.Diary
import com.rnk0085.selfcare.ui.currentTimeMillis
import com.rnk0085.selfcare.ui.screen.reflection.section.moodSelector.MoodType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ReflectionViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ReflectionUiState.InitialValue)
    val uiState: StateFlow<ReflectionUiState> = _uiState.asStateFlow()

    fun onDateSelected(date: Long?) {
        _uiState.update {
            it.copy(
                selectedDate = date ?: currentTimeMillis,
                showDatePicker = false,
            )
        }
    }

    fun onMoodSelected(mood: MoodType) {
        _uiState.update {
            it.copy(
                selectedMood = mood,
            )
        }
    }

    fun openDatePicker() {
        _uiState.update {
            it.copy(
                showDatePicker = true,
            )
        }
    }

    fun closeDatePicker() {
        _uiState.update {
            it.copy(
                showDatePicker = false,
            )
        }
    }

    // TODO: firstText, secondText, thirdText の処理が同じなので共通化する
    fun onFirstTextChange(text: String) {
        _uiState.update {
            it.copy(
                firstText = text,
            )
        }
    }

    fun onSecondTextChange(text: String) {
        _uiState.update {
            it.copy(
                secondText = text,
            )
        }
    }

    fun onThirdTextChange(text: String) {
        _uiState.update {
            it.copy(
                thirdText = text,
            )
        }
    }

    fun onRecordClick() {
        val diary = Diary(
            date = uiState.value.selectedDate,
            moodId = uiState.value.selectedMood?.ordinal ?: -1,
            firstGoodThing = uiState.value.firstText,
            secondGoodThing = uiState.value.secondText,
            thirdGoodThing = uiState.value.thirdText,
            createdAt = Timestamp.now(),
        )

        viewModelScope.launch {
            _uiState.update {
                it.copy(recordState = RecordState.Loading)
            }

            try {
                diaryRepository.add(diary)
                _uiState.update {
                    it.copy(recordState = RecordState.Success)
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        recordState = RecordState.Error(
                            message = e.message ?: "不明なエラーが発生しました",
                        ),
                    )
                }
            }
        }
    }

    fun resetRecordState() {
        _uiState.update {
            it.copy(recordState = RecordState.Idle)
        }
    }
}
