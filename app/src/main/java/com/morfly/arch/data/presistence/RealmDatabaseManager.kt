package com.morfly.arch.data.presistence

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmList
import com.morfly.arch.data.RepositoryResponse
import com.morfly.arch.domain.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealmDatabaseManager
@Inject
constructor(private val realmConfig: RealmConfiguration) {

    fun saveRepositories(repositories: List<RepositoryResponse>) {
        val realm = Realm.getInstance(realmConfig)
        realm.executeTransaction {

            val realmList = RealmList<RealmRepository>()
            realmList.addAll(repositories.map { it.toPersistence() })
            it.insertOrUpdate(realmList)
        }
    }

    fun loadRepositories(): List<Repository> {
        val realm = Realm.getInstance(realmConfig)

        val results = realm.where(RealmRepository::class.java)
                .findAll()
        return results.toList().map { it.toDomain() }
    }
}