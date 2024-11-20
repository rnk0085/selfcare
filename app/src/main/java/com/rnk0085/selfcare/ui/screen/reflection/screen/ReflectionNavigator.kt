package com.rnk0085.selfcare.ui.screen.reflection.screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.selfcare.ui.screen.Screen

internal fun NavGraphBuilder.reflection(
    navController: NavController,
) {
    composable<Screen.Reflection> {
        ReflectionScreen(
            onBackClicked = { navController.popBackStack() },
        )
    }
}
