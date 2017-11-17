package com.morfly.arch

import android.app.Application
import android.databinding.DataBindingUtil
import io.realm.Realm
import com.morfly.arch.data.di.ApplicationModule
import com.morfly.arch.data.di.BindingComponent
import com.morfly.arch.data.di.RetrofitApiModule


open class AppDelegate : Application() {

    companion object {

        const val API_ENDPOINT = "https://api.github.com"

        lateinit var instance: AppDelegate
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