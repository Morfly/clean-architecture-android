package mobi.asta.task2.presentation.repolist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.morfly.cleanarchitecture.core.presentationlayer.BaseFragment
import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter
import mobi.asta.task2.BR
import mobi.asta.task2.R
import mobi.asta.task2.Task2Application
import mobi.asta.task2.databinding.FragmentRepositoryListBinding
import mobi.asta.task2.presentation.repodetails.RepoDetailsFragment
import mobi.asta.task2.presentation.repolist.adapter.RepoListItem


class RepoListFragment : BaseFragment<RepoListContract.Presenter, FragmentRepositoryListBinding>(), RepoListContract.View {


    override fun getViewModelBindingId() = BR.viewModel

    override fun getLayoutId() = R.layout.fragment_repository_list

    override fun inject() {
        Task2Application.instance
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
                    .replace(R.id.container, RepoDetailsFragment.newInstance(it.viewModel.repository))
                    .addToBackStack(RepoDetailsFragment::class.java.name)
                    .commit()
        }

        val layoutManager = LinearLayoutManager(activity)
        binding.listRepos.layoutManager = layoutManager
        binding.listRepos.adapter = adapter
    }


}