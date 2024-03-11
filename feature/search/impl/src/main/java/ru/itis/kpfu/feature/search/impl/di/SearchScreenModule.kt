package ru.itis.kpfu.feature.search.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.search.api.SearchScreen
import ru.itis.kpfu.feature.search.impl.api.SearchScreenImpl

@Module
interface SearchScreenModule {

    @Binds
    fun bindSearchScreen(screen: SearchScreenImpl): SearchScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(SearchScreen::class)
    fun bindSearchScreenToMap(screen: SearchScreen): Any
}
