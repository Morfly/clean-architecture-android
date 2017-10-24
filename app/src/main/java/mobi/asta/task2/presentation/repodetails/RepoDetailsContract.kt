package mobi.asta.task2.presentation.repodetails

import com.morfly.cleanarchitecture.core.presentationlayer.BasePresenter
import com.morfly.cleanarchitecture.core.presentationlayer.BaseView
import mobi.asta.task2.domain.Repository


interface RepoDetailsContract {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View, RepoDetailsViewModel>() {

        abstract var repository: Repository
    }
}