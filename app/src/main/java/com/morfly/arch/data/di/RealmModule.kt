package com.morfly.arch.data.di

import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration
import com.morfly.arch.data.presistence.RealmDatabaseManager
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