package com.morfly.arch.domain

import io.reactivex.Observable


interface ReposRepository {

    fun getUserRepositories(username: String): Observable<List<Repository>>

}