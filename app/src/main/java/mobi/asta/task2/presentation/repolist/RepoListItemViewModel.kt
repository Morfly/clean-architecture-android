package mobi.asta.task2.presentation.repolist

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel
import mobi.asta.task2.domain.Repository


class RepoListItemViewModel(private val repository: Repository) : BaseObservable(), ViewModel {

    @get:Bindable
    val title: String
        get() = repository.title

    @get:Bindable
    val description: String
        get() = repository.description ?: ""

    @get:Bindable
    val language: String
        get() = repository.language ?: ""

    @get:Bindable
    val numberOfStars: String
        get() = repository.numberOfStars.toString()

    @get:Bindable
    val numberOfForks: String
        get() = repository.numberOfForks.toString()

    @get:Bindable
    val updateDate: String
        get() = repository.updateDate.toString()
}