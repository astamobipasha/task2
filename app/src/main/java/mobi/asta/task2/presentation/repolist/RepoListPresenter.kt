package mobi.asta.task2.presentation.repolist

import android.databinding.ObservableArrayList
import android.os.Bundle
import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobi.asta.task2.domain.getjakewhartonrepos.GetJakeWhartonReposInteractor
import mobi.asta.task2.presentation.repolist.adapter.RepoListItem
import mobi.asta.task2.presentation.repolist.adapter.toPresentation
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