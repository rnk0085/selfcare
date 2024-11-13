package com.rnk0085.selfcare.ui.screen

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object DiaryList : Screen

    @Serializable
    data object Reflection : Screen
}
