package com.morfly.arch.presentation.repodetails

import com.morfly.cleanarchitecture.core.presentationlayer.BasePresenter
import com.morfly.cleanarchitecture.core.presentationlayer.BaseView
import com.morfly.arch.domain.Repository


interface RepoDetailsContract {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View, RepoDetailsViewModel>() {

        abstract var repository: Repository
    }
}