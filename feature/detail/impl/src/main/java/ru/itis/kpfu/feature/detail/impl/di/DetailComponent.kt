package ru.itis.kpfu.feature.detail.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.detail.api.DetailScreenModel
import ru.itis.kpfu.feature.detail.impl.presentation.DetailFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        DetailScreensModule::class,
        DetailViewModelModule::class
    ]
)
internal interface DetailComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: DetailScreenModel,
        ): DetailComponent {
            return DaggerDetailComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: DetailScreenModel,
        ): DetailComponent
    }

    fun inject(fragment: DetailFragment)

}
