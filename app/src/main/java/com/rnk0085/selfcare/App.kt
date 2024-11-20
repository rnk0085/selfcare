package com.rnk0085.selfcare

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rnk0085.selfcare.ui.screen.Screen
import com.rnk0085.selfcare.ui.screen.diaryList.diaryList
import com.rnk0085.selfcare.ui.screen.reflection.screen.reflection

@Composable
internal fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.DiaryList,
    ) {
        diaryList(navController)

        reflection(navController)
    }
}
