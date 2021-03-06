package mobi.asta.task2

import dagger.Component
import mobi.asta.task2.data.di.ApplicationModule
import mobi.asta.task2.data.di.RealmModule
import mobi.asta.task2.data.di.RepositoryModule
import mobi.asta.task2.data.di.RetrofitApiModule
import mobi.asta.task2.presentation.repodetails.di.RepoDetailsComponent
import mobi.asta.task2.presentation.repolist.di.RepoListComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        RetrofitApiModule::class,
        RepositoryModule::class,
        RealmModule::class
))
interface ApplicationComponent {

    fun plusRepoList(): RepoListComponent.Builder

    fun plusRepoDetails(): RepoDetailsComponent.Builder
}