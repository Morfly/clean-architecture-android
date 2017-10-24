package mobi.asta.task2.presentation.repodetails

import android.os.Bundle
import com.morfly.cleanarchitecture.core.presentationlayer.BaseFragment
import mobi.asta.task2.BR
import mobi.asta.task2.R
import mobi.asta.task2.Task2Application
import mobi.asta.task2.databinding.FragmentRepoDetailsBinding
import mobi.asta.task2.domain.Repository


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
        Task2Application.instance.component
                .plusRepoDetails()
                .build()
                .inject(this)
    }
}