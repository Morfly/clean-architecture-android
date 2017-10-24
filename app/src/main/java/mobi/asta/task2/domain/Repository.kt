package mobi.asta.task2.domain

import java.util.*


data class Repository(val id: Int,
                      val title: String,
                      val description: String?,
                      val numberOfStars: Int,
                      val numberOfForks: Int,
                      val numberOfWatchers: Int,
                      val numberOfIssues: Int,
                      val language: String?,
                      val updateDate: Date)