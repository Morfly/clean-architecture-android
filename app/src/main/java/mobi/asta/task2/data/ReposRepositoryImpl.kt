package mobi.asta.task2.data

import io.reactivex.Observable
import io.reactivex.Single
import mobi.asta.task2.data.network.RestApi
import mobi.asta.task2.domain.ReposRepository
import mobi.asta.task2.domain.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReposRepositoryImpl
@Inject
constructor(private val restApi: RestApi) : ReposRepository {

    override fun getUserRepositories(username: String): Single<List<Repository>> {
        return restApi.getUserRepositories(username)
                .toObservable()
                .flatMapIterable { it }
                .map { it.toDomain() }
                .toList()
    }
}