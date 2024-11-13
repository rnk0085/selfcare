package com.rnk0085.selfcare.ui.screen.diaryList

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.selfcare.ui.screen.Screen

internal fun NavGraphBuilder.diaryList() {
    composable<Screen.DiaryList> {
        DiaryListScreen()
    }
}
