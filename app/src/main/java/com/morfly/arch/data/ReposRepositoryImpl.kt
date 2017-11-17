package com.morfly.arch.data

import io.reactivex.Observable
import io.reactivex.Single
import com.morfly.arch.data.network.RestApi
import com.morfly.arch.data.presistence.RealmDatabaseManager
import com.morfly.arch.domain.ReposRepository
import com.morfly.arch.domain.Repository
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