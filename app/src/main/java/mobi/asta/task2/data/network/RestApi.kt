package mobi.asta.task2.data.network

import io.reactivex.Single
import mobi.asta.task2.data.RepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RestApi {

    @GET("/users/{username}/repos")
    fun getUserRepositories(@Path("username") username: String,
                            @Query("type") type: String? = null,
                            @Query("sort") sort: String? = null,
                            @Query("direction") direction: String? = null): Single<List<RepositoryResponse>>
}