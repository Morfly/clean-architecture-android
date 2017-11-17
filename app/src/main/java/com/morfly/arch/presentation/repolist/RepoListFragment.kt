package com.morfly.arch.presentation.repolist

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.morfly.arch.BR
import com.morfly.arch.R
import com.morfly.arch.AppDelegate
import com.morfly.arch.databinding.FragmentRepositoryListBinding
import com.morfly.arch.presentation.repodetails.RepoDetailsFragment
import com.morfly.arch.presentation.repolist.adapter.RepoListItem
import com.morfly.cleanarchitecture.core.presentationlayer.BaseFragment
import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter


class RepoListFragment : BaseFragment<RepoListContract.Presenter, FragmentRepositoryListBinding>(), RepoListContract.View {


    override fun getViewModelBindingId() = BR.viewModel

    override fun getLayoutId() = R.layout.fragment_repository_list

    override fun inject() {
        AppDelegate.instance
                .component
                .plusRepoList()
                .build()
                .inject(this)
    }

    override fun onCreateView(savedInstanceState: Bundle?) {

        val adapter = BindingAdapter<RepoListItem>()
        adapter.setOnItemClickListener {
            activity.supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, RepoDetailsFragment.newInstance(it.viewModel.repository))
                    .addToBackStack(RepoDetailsFragment::class.java.name)
                    .commit()
        }

        val layoutManager = LinearLayoutManager(activity)
        binding.listRepos.layoutManager = layoutManager
        binding.listRepos.adapter = adapter

        val divider = DividerItemDecoration(activity, layoutManager.orientation)
        binding.listRepos.addItemDecoration(divider)
    }


}