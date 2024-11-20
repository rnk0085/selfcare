package com.rnk0085.selfcare.ui.screen.reflection.section.threeGoodThings

data class GoodThingItem(
    val keyboardEvent: KeyboardEvent,
    val placeHolderText: String,
    val value: String,
    val onValueChange: (String) -> Unit,
)