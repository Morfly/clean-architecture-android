package mobi.asta.task2.data

import io.reactivex.Observable
import io.reactivex.Single
import mobi.asta.task2.data.network.RestApi
import mobi.asta.task2.data.presistence.RealmDatabaseManager
import mobi.asta.task2.domain.ReposRepository
import mobi.asta.task2.domain.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReposRepositoryImpl
@Inject
constructor(private val restApi: RestApi,
            private val dbManager: RealmDatabaseManager) : ReposRepository {

    override fun getUserRepositories(username: String): Observable<List<Repository>> {
        val remote: Single<List<Repository>> = restApi
                .getUserRepositories(username)
                .doOnSuccess { dbManager.saveRepositories(it) }
                .map { dbManager.loadRepositories() }
                .onErrorReturn { dbManager.loadRepositories() }

        val local: Single<List<Repository>> = Single.just(dbManager.loadRepositories())

        return Single.concat<List<Repository>>(local, remote)
                .toObservable()
    }
}