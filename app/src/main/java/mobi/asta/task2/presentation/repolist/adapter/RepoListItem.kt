package mobi.asta.task2.presentation.repolist.adapter

import com.android.databinding.library.baseAdapters.BR
import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BaseBindingItem
import mobi.asta.task2.R
import mobi.asta.task2.domain.Repository
import mobi.asta.task2.presentation.repolist.RepoListItemViewModel


class RepoListItem(viewModel: RepoListItemViewModel) : BaseBindingItem<RepoListItemViewModel>(viewModel) {
    override fun getLayoutId() = R.layout.list_item_repository

    override fun getViewModelBindingId() = BR.viewModel
}

fun Repository.toPresentation() = RepoListItem(
        RepoListItemViewModel(repository = this)
)

fun List<Repository>.toPresentation() = this.map { it.toPresentation() }