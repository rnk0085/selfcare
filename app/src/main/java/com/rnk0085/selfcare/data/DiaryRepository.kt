package com.rnk0085.selfcare.data

import com.rnk0085.selfcare.domain.model.Diary

interface DiaryRepository {
    suspend fun add(diary: Diary)
}