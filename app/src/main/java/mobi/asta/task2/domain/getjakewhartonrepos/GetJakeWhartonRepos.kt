package mobi.asta.task2.domain.getjakewhartonrepos

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import com.morfly.cleanarchitecture.core.domainlayer.ArgumentlessInteractor
import io.reactivex.Single
import mobi.asta.task2.domain.ReposRepository
import mobi.asta.task2.domain.Repository
import javax.inject.Inject


interface GetJakeWhartonReposInteractor : ArgumentlessInteractor<Single<List<Repository>>>


@PerFragment
class GetJakeWhartonReposUseCase
@Inject
constructor(private val repository: ReposRepository) : GetJakeWhartonReposInteractor {

    companion object {
        const val JAKE_WHARTON_USERNAME = "JakeWharton"
    }

    override fun execute(): Single<List<Repository>> {
        return repository.getUserRepositories(JAKE_WHARTON_USERNAME)
    }

}