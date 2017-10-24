package mobi.asta.task2.data.di

import dagger.Binds
import dagger.Module
import mobi.asta.task2.data.ReposRepositoryImpl
import mobi.asta.task2.domain.ReposRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun repos(repository: ReposRepositoryImpl): ReposRepository
}