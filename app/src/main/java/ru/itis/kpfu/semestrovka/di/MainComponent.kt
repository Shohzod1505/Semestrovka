package ru.itis.kpfu.semestrovka.di

import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.semestrovka.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ApplicationProvider::class,
    ],
    modules = [
        ScreensBinding::class,
        MainViewModelModule::class,
    ]
)
internal interface MainComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider
        ): MainComponent {
            return DaggerMainComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider
        ): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}
