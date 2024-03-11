package ru.itis.kpfu.core.database.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.database.data.AppDatabase
import ru.itis.kpfu.core.database.data.dao.AccountDao
import ru.itis.kpfu.core.database.data.dao.NewsDao
import ru.itis.kpfu.core.database.data.repository.AccountRepositoryImpl
import ru.itis.kpfu.core.database.data.repository.NewsRepositoryImpl
import ru.itis.kpfu.core.database.domain.AccountRepository
import ru.itis.kpfu.core.database.domain.NewsRepository
import javax.inject.Singleton

@Module
internal abstract class DatabaseModule {

    @Singleton
    @Binds
    abstract fun provideAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository

    @Singleton
    @Binds
    abstract fun provideNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository

    companion object {
        @Singleton
        @Provides
        fun getRoomDatabaseInstance(
            context: Context
        ): AppDatabase = AppDatabase.getAppDatabaseInstance(context)

        @Singleton
        @Provides
        fun getAccountDao(
            appDatabase: AppDatabase
        ): AccountDao = appDatabase.getAccountDao()

        @Singleton
        @Provides
        fun getNewsDao(
            appDatabase: AppDatabase
        ): NewsDao = appDatabase.getNewsDao()
    }
}
