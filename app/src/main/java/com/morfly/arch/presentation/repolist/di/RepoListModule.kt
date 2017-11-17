package com.morfly.arch.presentation.repolist.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import com.morfly.arch.domain.getjakewhartonrepos.GetJakeWhartonReposInteractor
import com.morfly.arch.domain.getjakewhartonrepos.GetJakeWhartonReposUseCase
import com.morfly.arch.presentation.repolist.RepoListContract
import com.morfly.arch.presentation.repolist.RepoListPresenter

@Module
interface RepoListModule {

    @PerFragment
    @Binds
    fun repoListPresenter(presenter: RepoListPresenter): RepoListContract.Presenter

    @PerFragment
    @Binds
    fun getJakeWhartonRepos(useCase: GetJakeWhartonReposUseCase): GetJakeWhartonReposInteractor

}