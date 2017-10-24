package mobi.asta.task2

import android.app.Application
import mobi.asta.task2.data.di.ApplicationModule
import mobi.asta.task2.data.di.RetrofitApiModule


open class Task2Application : Application() {

    companion object {

        const val API_ENDPOINT = "https://api.github.com"

        lateinit var instance: Task2Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    //region Dependency injection
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .retrofitApiModule(RetrofitApiModule(API_ENDPOINT))
                .applicationModule(ApplicationModule(this))
                .build()
    }
    //endregion
}