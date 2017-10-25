package mobi.asta.task2.data.presistence

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import mobi.asta.task2.data.RepositoryResponse
import mobi.asta.task2.domain.Repository
import java.util.*


open class RealmRepository : RealmObject() {

    @PrimaryKey
    var id: Int = 0

    var title: String? = null

    var description: String? = null

    var numberOfStars: Int = 0

    var numberOfForks: Int = 0

    var numberOfWatchers: Int = 0

    var numberOfIssues: Int = 0

    var language: String? = null

    var updateDate: Date? = null

}

fun RepositoryResponse.toPersistence(): RealmRepository {
    val realmRepository = RealmRepository()
    realmRepository.id = id
    realmRepository.title = name
    realmRepository.description = description
    realmRepository.numberOfForks = forksCount
    realmRepository.numberOfIssues = openIssuesCount
    realmRepository.numberOfStars = stargazersCount
    realmRepository.numberOfWatchers = watchersCount
    realmRepository.language = language
    realmRepository.updateDate = updatedAt
    return realmRepository
}

fun RealmRepository.toDomain() = Repository(
        id = id,
        title = title ?: "",
        description = description,
        numberOfStars = numberOfStars,
        numberOfForks = numberOfForks,
        numberOfIssues = numberOfIssues,
        numberOfWatchers = numberOfWatchers,
        language = language,
        updateDate = updateDate
)