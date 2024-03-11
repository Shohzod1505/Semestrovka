package ru.itis.kpfu.feature.saved.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.saved.api.SavedScreenModel
import ru.itis.kpfu.feature.saved.impl.presentation.SavedFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        SavedScreensModule::class,
        SavedViewModelModule::class
    ]
)
internal interface SavedComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: SavedScreenModel,
        ): SavedComponent {
            return DaggerSavedComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: SavedScreenModel,
        ): SavedComponent
    }

    fun inject(fragment: SavedFragment)

}
