package com.rnk0085.selfcare

import com.rnk0085.selfcare.data.DiaryRepository
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionUiState
import com.rnk0085.selfcare.ui.screen.reflection.ReflectionViewModel
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ReflectionViewModelTest {
    val diaryRepository = mockk<DiaryRepository>()

    @Test
    fun uiStateReflection_whenInitialized_thenInitialValue() {
        val viewModel = ReflectionViewModel(
            diaryRepository = diaryRepository,
        )

        assertEquals(viewModel.uiState.value, ReflectionUiState.InitialValue)
    }
}