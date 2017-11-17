package com.morfly.arch

import dagger.Component
import com.morfly.arch.data.di.ApplicationModule
import com.morfly.arch.data.di.RealmModule
import com.morfly.arch.data.di.RepositoryModule
import com.morfly.arch.data.di.RetrofitApiModule
import com.morfly.arch.presentation.repodetails.di.RepoDetailsComponent
import com.morfly.arch.presentation.repolist.di.RepoListComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        RetrofitApiModule::class,
        RepositoryModule::class,
        RealmModule::class
))
interface ApplicationComponent {

    fun plusRepoList(): RepoListComponent.Builder

    fun plusRepoDetails(): RepoDetailsComponent.Builder
}