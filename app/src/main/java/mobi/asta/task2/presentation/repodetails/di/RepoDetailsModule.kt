package mobi.asta.task2.presentation.repodetails.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import mobi.asta.task2.presentation.repodetails.RepoDetailsContract
import mobi.asta.task2.presentation.repodetails.RepoDetailsPresenter

@Module
interface RepoDetailsModule {

    @PerFragment
    @Binds
    fun presente(presenter: RepoDetailsPresenter): RepoDetailsContract.Presenter
}