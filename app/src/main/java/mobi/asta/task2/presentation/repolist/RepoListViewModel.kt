package mobi.asta.task2.presentation.repolist

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel
import mobi.asta.task2.presentation.repolist.adapter.RepoListItem


class RepoListViewModel : BaseObservable(), ViewModel {

    val repos: ObservableList<RepoListItem> = ObservableArrayList()
}