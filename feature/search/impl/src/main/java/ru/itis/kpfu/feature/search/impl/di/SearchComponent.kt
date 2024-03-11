package ru.itis.kpfu.feature.search.impl.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.core.common.app.ApplicationProvider
import ru.itis.kpfu.feature.search.api.SearchScreenModel
import ru.itis.kpfu.feature.search.impl.presentation.SearchFragment

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        SearchScreensModule::class,
        SearchViewModelModule::class
    ]
)
internal interface SearchComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            model: SearchScreenModel,
        ): SearchComponent {
            return DaggerSearchComponent.factory()
                .create(applicationProvider, model)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance model: SearchScreenModel,
        ): SearchComponent
    }

    fun inject(fragment: SearchFragment)

}
