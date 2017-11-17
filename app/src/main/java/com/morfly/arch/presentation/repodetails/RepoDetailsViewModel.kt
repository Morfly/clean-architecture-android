package com.morfly.arch.presentation.repodetails

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel
import com.morfly.arch.domain.Repository


class RepoDetailsViewModel(val repository: Repository?) : BaseObservable(), ViewModel {

    companion object {
        fun idle() = null
    }

    @get:Bindable
    val title: String
        get() = repository?.title ?: ""

    @get:Bindable
    val description: String
        get() = repository?.description ?: ""

    @get:Bindable
    val numberOfStars: String
        get() = repository?.numberOfStars.toString() ?: ""

    @get:Bindable
    val numberOfForks: String
        get() = repository?.numberOfForks.toString() ?: ""

    @get:Bindable
    val numberOfWatchers: String
        get() = repository?.numberOfWatchers.toString() ?: ""

    @get:Bindable
    val numberOfIssues: String
        get() = repository?.numberOfIssues.toString() ?: ""
}