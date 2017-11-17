package com.morfly.arch.presentation.repolist

import android.annotation.SuppressLint
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel
import com.morfly.arch.domain.Repository
import java.text.SimpleDateFormat


data class RepoListItemViewModel(val repository: Repository) : BaseObservable(), ViewModel {

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
        @SuppressLint("SimpleDateFormat")
        get() = SimpleDateFormat("yyyy-MM-dd")
                .format(repository.updateDate)

}