package mobi.asta.task2.presentation.repolist.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import mobi.asta.task2.presentation.repolist.RepoListContract
import mobi.asta.task2.presentation.repolist.RepoListPresenter

@Module
interface RepoListMobule {

    @PerFragment
    @Binds
    fun repoListPresenter(presenter: RepoListPresenter): RepoListContract.Presenter

}