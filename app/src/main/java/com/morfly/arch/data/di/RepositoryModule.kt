package com.morfly.arch.data.di

import dagger.Binds
import dagger.Module
import com.morfly.arch.data.ReposRepositoryImpl
import com.morfly.arch.domain.ReposRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun repos(repository: ReposRepositoryImpl): ReposRepository
}