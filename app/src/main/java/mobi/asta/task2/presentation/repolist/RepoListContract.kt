package mobi.asta.task2.presentation.repolist

import com.morfly.cleanarchitecture.core.presentationlayer.BasePresenter
import com.morfly.cleanarchitecture.core.presentationlayer.BaseView


interface RepoListContract {

    interface View: BaseView {

    }

    abstract class Presenter: BasePresenter<View, RepoListViewModel>() {

    }
}