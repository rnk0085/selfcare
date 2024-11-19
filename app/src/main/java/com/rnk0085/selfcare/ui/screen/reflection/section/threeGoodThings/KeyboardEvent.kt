package com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings

import androidx.compose.foundation.text.KeyboardActionScope

sealed interface KeyboardEvent {
    val onClick: KeyboardActionScope.() -> Unit

    data class Next(override val onClick: KeyboardActionScope.() -> Unit) : KeyboardEvent

    data class Done(override val onClick: KeyboardActionScope.() -> Unit) : KeyboardEvent
}