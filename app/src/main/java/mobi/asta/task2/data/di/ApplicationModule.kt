package mobi.asta.task2.data.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private val application : Application) {

    @Provides
    @Singleton
    internal fun provideApplication() : Application = application

    @Provides
    @Singleton
    internal fun provideContext() : Context = application
}