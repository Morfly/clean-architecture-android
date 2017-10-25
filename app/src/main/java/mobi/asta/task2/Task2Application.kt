package mobi.asta.task2

import android.app.Application
import android.databinding.DataBindingUtil
import io.realm.Realm
import mobi.asta.task2.data.di.ApplicationModule
import mobi.asta.task2.data.di.BindingComponent
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
        DataBindingUtil.setDefaultComponent(BindingComponent())
        Realm.init(this)
    }

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .retrofitApiModule(RetrofitApiModule(API_ENDPOINT))
                .applicationModule(ApplicationModule(this))
                .build()
    }
}