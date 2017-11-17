package com.morfly.arch.presentation.repolist

import com.morfly.cleanarchitecture.core.presentationlayer.BasePresenter
import com.morfly.cleanarchitecture.core.presentationlayer.BaseView


interface RepoListContract {

    interface View : BaseView {

    }

    abstract class Presenter : BasePresenter<View, RepoListViewModel>() {

        abstract fun getRepositories()
    }
}