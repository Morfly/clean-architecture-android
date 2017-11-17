package com.morfly.arch.presentation.repodetails

import android.os.Bundle
import com.morfly.arch.BR
import com.morfly.arch.R
import com.morfly.arch.AppDelegate
import com.morfly.arch.databinding.FragmentRepoDetailsBinding
import com.morfly.arch.domain.Repository
import com.morfly.cleanarchitecture.core.presentationlayer.BaseFragment


class RepoDetailsFragment : BaseFragment<RepoDetailsContract.Presenter, FragmentRepoDetailsBinding>(), RepoDetailsContract.View {


    companion object {
        const val KEY_REPOSITORY = "key_repository"

        fun newInstance(repository: Repository): RepoDetailsFragment {
            val args = Bundle()
            args.putParcelable(KEY_REPOSITORY, repository)
            val fragment = RepoDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getViewModelBindingId() = BR.viewModel

    override fun getLayoutId() = R.layout.fragment_repo_details

    override fun onCreateView(savedInstanceState: Bundle?) {
        val repository = arguments?.getParcelable<Repository>(KEY_REPOSITORY)
        repository?.let {
            presenter.repository = it
        }
    }

    override fun inject() {
        AppDelegate.instance.component
                .plusRepoDetails()
                .build()
                .inject(this)
    }
}