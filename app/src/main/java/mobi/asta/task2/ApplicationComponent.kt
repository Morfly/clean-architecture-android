package mobi.asta.task2

import dagger.Component
import mobi.asta.task2.data.di.ApplicationModule
import mobi.asta.task2.presentation.repolist.di.RepoListComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class
))
interface ApplicationComponent {

    fun plusRepoList(): RepoListComponent.Builder
}