package com.rnk0085.selfcare.ui.screen.diaryList

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.selfcare.ui.screen.Screen

internal fun NavGraphBuilder.diaryList(
    navController: NavController,
) {
    composable<Screen.DiaryList> {
        DiaryListScreen(
            onNavigateToReflection = { navController.navigate(Screen.Reflection) },
        )
    }
}
