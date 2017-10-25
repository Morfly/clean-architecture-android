package mobi.asta.task2.data.di

import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration
import mobi.asta.task2.data.presistence.RealmDatabaseManager
import javax.inject.Singleton

@Module
class RealmModule {

    @Provides
    @Singleton
    fun realmConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder()
                .build()
    }

    @Provides
    @Singleton
    fun dbManager(realmConfiguration: RealmConfiguration) = RealmDatabaseManager(realmConfiguration)
}