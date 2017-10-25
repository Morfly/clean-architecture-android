package mobi.asta.task2.domain

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single


interface ReposRepository {

    fun getUserRepositories(username: String): Observable<List<Repository>>

}