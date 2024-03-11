package ru.itis.kpfu.semestrovka.di

import dagger.Component
import ru.itis.kpfu.core.common.CoreFactory
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.core.common.CoreProvider
import ru.itis.kpfu.core.common.viewmodel.ViewModelFactoryModule
import ru.itis.kpfu.core.database.di.DatabaseComponent
import ru.itis.kpfu.core.database.di.DatabaseProvider
import ru.itis.kpfu.core.navigation.NavigationComponent
import ru.itis.kpfu.core.navigation.NavigationProvider
import ru.itis.kpfu.core.network.di.NetworkComponent
import ru.itis.kpfu.core.network.di.NetworkProvider
import ru.itis.kpfu.semestrovka.app.MyApp
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreProvider::class,
        DatabaseProvider::class,
        NetworkProvider::class,
        NavigationProvider::class,
    ],
    modules = [
        ViewModelFactoryModule::class,
        ScreensBinding::class,
    ]
)
interface ApplicationComponent : ApplicationProvider {

    companion object {
        fun init(app: MyApp): ApplicationProvider {
            val androidProvider = CoreFactory.createCoreProvider(app)
            return DaggerApplicationComponent.factory()
                .create(
                    coreProvider = androidProvider,
                    databaseProvider = DatabaseComponent.init(),
                    networkProvider = NetworkComponent.init(),
                    navigationProvider = NavigationComponent.init(),
                )
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            coreProvider: CoreProvider,
            databaseProvider: DatabaseProvider,
            networkProvider: NetworkProvider,
            navigationProvider: NavigationProvider,
        ): ApplicationComponent
    }

    fun inject(app: MyApp)
}
