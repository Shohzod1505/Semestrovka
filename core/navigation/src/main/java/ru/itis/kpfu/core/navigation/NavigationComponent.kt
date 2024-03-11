package ru.itis.kpfu.core.navigation

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NavigationModule::class],
)
interface NavigationComponent : NavigationProvider {

    companion object {

        fun init(): NavigationProvider {
            return DaggerNavigationComponent.factory()
                .create()
        }
    }

    @Component.Factory
    interface Factory {
        fun create(): NavigationProvider
    }

}
