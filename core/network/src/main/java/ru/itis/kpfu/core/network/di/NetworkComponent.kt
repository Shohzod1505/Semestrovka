package ru.itis.kpfu.core.network.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class],
)
interface NetworkComponent : NetworkProvider {

    companion object {

        fun init(): NetworkProvider {
            return DaggerNetworkComponent.factory()
                .create()
        }
    }

    @Component.Factory
    interface Factory {
        fun create(): NetworkProvider
    }

}
