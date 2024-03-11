package ru.itis.kpfu.feature.detail.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.detail.api.DetailScreen
import ru.itis.kpfu.feature.detail.impl.api.DetailScreenImpl

@Module
interface DetailScreenModule {

    @Binds
    fun bindDetailScreen(screen: DetailScreenImpl): DetailScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(DetailScreen::class)
    fun bindDetailScreenToMap(screen: DetailScreen): Any
}
