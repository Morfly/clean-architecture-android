package com.morfly.arch.presentation.repolist

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel
import com.morfly.arch.presentation.repolist.adapter.RepoListItem


class RepoListViewModel(val repos: ObservableList<RepoListItem> = ObservableArrayList<RepoListItem>())
    : BaseObservable(), ViewModel {

}