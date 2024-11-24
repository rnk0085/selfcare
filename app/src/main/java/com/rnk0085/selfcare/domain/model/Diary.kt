package com.rnk0085.selfcare.domain.model

import com.google.firebase.Timestamp

data class Diary(
    val date: Long,
    val moodId: Int,
    val firstGoodThing: String,
    val secondGoodThing: String,
    val thirdGoodThing: String,
    val createdAt: Timestamp,
)

fun Diary.toMap(): Map<String, Any> {
    return hashMapOf(
        "date" to date,
        "moodId" to moodId,
        "firstGoodThing" to firstGoodThing,
        "secondGoodThing" to secondGoodThing,
        "thirdGoodThing" to thirdGoodThing,
        "createdAt" to createdAt,
    )
}