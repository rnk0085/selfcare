package com.rnk0085.selfcare.di

import com.rnk0085.selfcare.data.DiaryRepository
import com.rnk0085.selfcare.data.DiaryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDiaryRepository(
        diaryRepositoryImpl: DiaryRepositoryImpl
    ) : DiaryRepository
}