package mobi.asta.task2.presentation.repodetails

import com.morfly.cleanarchitecture.core.di.scope.PerFragment
import mobi.asta.task2.domain.Repository
import javax.inject.Inject

@PerFragment
class RepoDetailsPresenter
@Inject
constructor() : RepoDetailsContract.Presenter() {

    private lateinit var _repository: Repository

    override var repository: Repository
        get() = _repository
        set(value) {
            _repository = value
            viewModel = RepoDetailsViewModel(_repository)
        }

    init {
        viewModel = RepoDetailsViewModel.idle()
    }
}