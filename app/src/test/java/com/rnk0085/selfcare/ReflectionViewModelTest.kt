package com.rnk0085.selfcare

import com.rnk0085.selfcare.data.DiaryRepository
import com.rnk0085.selfcare.ui.screen.reflection.RecordState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionUiState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ReflectionViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    val diaryRepository = mockk<DiaryRepository>()

    @Test
    fun uiStateReflection_whenInitialized_thenInitialValue() {
        val viewModel = ReflectionViewModel(
            diaryRepository = diaryRepository,
        )

        assertEquals(ReflectionUiState.InitialValue, viewModel.uiState.value)
    }

    @Test
    fun uiStateReflection_whenOnRecordClickSuccess_thenUpdateRecordStateSuccess() = runTest {
        // 参考：https://speakerdeck.com/tkmnzm/update-your-automated-tests-to-match-androids-modern-technology-choices?slide=118
        coEvery { diaryRepository.add(any()) } coAnswers {
            delay(100)
        }
        val viewModel = ReflectionViewModel(
            diaryRepository = diaryRepository,
        )
        // Flowの値を観察
        val stateList = mutableListOf<RecordState>()
        val job = launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.uiState.map { it.recordState }.toList(stateList)
        }

        viewModel.onRecordClick()
        advanceUntilIdle()

        coVerify(exactly = 1) {
            diaryRepository.add(any())
        }

        job.cancel()
        val expectedStates = listOf(RecordState.Idle, RecordState.Loading, RecordState.Success)
        assertEquals(expectedStates, stateList)
    }
}
