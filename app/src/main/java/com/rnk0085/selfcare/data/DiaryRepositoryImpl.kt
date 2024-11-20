package com.rnk0085.selfcare.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rnk0085.selfcare.domain.model.Diary
import com.rnk0085.selfcare.domain.model.toMap
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor() : DiaryRepository {
    private val database = Firebase.firestore

    override suspend fun add(diary: Diary) {
        database.collection("diarys")
            .add(diary.toMap())
            .addOnSuccessListener {
                // TODO
            }
            .addOnFailureListener {
                // TODO
            }
    }
}