package mobi.asta.task2.presentation.repolist.di

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import dagger.Subcomponent
import mobi.asta.task2.presentation.repolist.RepoListFragment

@PerFragment
@Subcomponent(modules = arrayOf(RepoListModule::class))
interface RepoListComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RepoListComponent
    }

    fun inject(fragment: RepoListFragment)
}