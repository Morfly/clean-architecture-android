package mobi.asta.task2.data

import com.google.gson.annotations.SerializedName
import mobi.asta.task2.domain.Repository
import java.util.*


data class RepositoryResponse(val id: Int,
                              val name: String,
                              val description: String?,
                              @SerializedName("watchers_count")
                              val watchersCount: Int = 0,
                              @SerializedName("forks_count")
                              val forksCount: Int = 0,
                              @SerializedName("stargazers_count")
                              val stargazersCount: Int = 0,
                              @SerializedName("open_issues_count")
                              val openIssuesCount: Int = 0,
                              val language: String?,
                              @SerializedName("updated_at")
                              val updatedAt: Date) {
}


fun RepositoryResponse.toDomain() = Repository(
        id = id,
        title = name,
        description = description,
        numberOfForks = forksCount,
        numberOfIssues = openIssuesCount,
        numberOfStars = stargazersCount,
        numberOfWatchers = watchersCount,
        language = language,
        updateDate = updatedAt
)