package ru.itis.kpfu.core.database.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DatabaseModule::class],
)
interface DatabaseComponent : DatabaseProvider {

    companion object {

        fun init(): DatabaseProvider {
            return DaggerDatabaseComponent.factory()
                .create()
        }
    }

    @Component.Factory
    interface Factory {
        fun create(): DatabaseProvider
    }

}
