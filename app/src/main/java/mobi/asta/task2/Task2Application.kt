package mobi.asta.task2

import android.app.Application
import mobi.asta.task2.data.di.ApplicationModule


open class Task2Application : Application() {

    //region Singleton
    companion object {
        lateinit var instance: Task2Application
            private set
    }
    //endregion

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    //region Dependency injection
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
    //endregion
}