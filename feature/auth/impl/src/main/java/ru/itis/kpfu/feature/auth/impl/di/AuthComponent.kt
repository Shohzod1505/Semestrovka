package ru.itis.kpfu.feature.auth.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.auth.api.AuthScreenModel
import ru.itis.kpfu.feature.auth.impl.presentation.AuthFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        AuthScreensModule::class,
        AuthViewModelModule::class
    ]
)
internal interface AuthComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: AuthScreenModel,
        ): AuthComponent {
            return DaggerAuthComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: AuthScreenModel,
        ): AuthComponent
    }

    fun inject(fragment: AuthFragment)

}
