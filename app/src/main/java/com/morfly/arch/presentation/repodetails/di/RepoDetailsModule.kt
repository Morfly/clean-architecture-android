package com.morfly.arch.presentation.repodetails.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import com.morfly.arch.presentation.repodetails.RepoDetailsContract
import com.morfly.arch.presentation.repodetails.RepoDetailsPresenter

@Module
interface RepoDetailsModule {

    @PerFragment
    @Binds
    fun presente(presenter: RepoDetailsPresenter): RepoDetailsContract.Presenter
}