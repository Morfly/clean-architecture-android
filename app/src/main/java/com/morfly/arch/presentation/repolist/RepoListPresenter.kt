package com.morfly.arch.presentation.repolist

import android.os.Bundle
import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.morfly.arch.domain.getjakewhartonrepos.GetJakeWhartonReposInteractor
import com.morfly.arch.presentation.repolist.adapter.RepoListItem
import com.morfly.arch.presentation.repolist.adapter.toPresentation
import javax.inject.Inject

@PerFragment
class RepoListPresenter
@Inject
constructor(private val getJakeWhartonRepos: GetJakeWhartonReposInteractor) : RepoListContract.Presenter() {

    init {
        viewModel = RepoListViewModel()
    }

    override fun onViewAttached(savedInstanceState: Bundle?) {
        getRepositories()
    }

    override fun getRepositories() {
        subscribe(
                getJakeWhartonRepos.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ onReposLoaded(it.toPresentation()) }, this::onError)
        )
    }

    private fun onReposLoaded(repos: List<RepoListItem>) {
        viewModel.repos.clear()
        viewModel.repos.addAll(repos)
    }

}