package mobi.asta.task2.presentation.repolist.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import mobi.asta.task2.domain.getjakewhartonrepos.GetJakeWhartonReposInteractor
import mobi.asta.task2.domain.getjakewhartonrepos.GetJakeWhartonReposUseCase
import mobi.asta.task2.presentation.repolist.RepoListContract
import mobi.asta.task2.presentation.repolist.RepoListPresenter

@Module
interface RepoListModule {

    @PerFragment
    @Binds
    fun repoListPresenter(presenter: RepoListPresenter): RepoListContract.Presenter

    @PerFragment
    @Binds
    fun getJakeWhartonRepos(useCase: GetJakeWhartonReposUseCase): GetJakeWhartonReposInteractor

}