package com.rnk0085.selfcare.ui.screen.reflection

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rnk0085.selfcare.ui.screen.Screen

internal fun NavGraphBuilder.reflection() {
    composable<Screen.Reflection> {
        ReflectionScreen()
    }
}
