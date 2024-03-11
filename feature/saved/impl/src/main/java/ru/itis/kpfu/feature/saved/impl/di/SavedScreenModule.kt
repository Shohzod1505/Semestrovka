package ru.itis.kpfu.feature.saved.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.saved.api.SavedScreen
import ru.itis.kpfu.feature.saved.impl.api.SavedScreenImpl

@Module
interface SavedScreenModule {

    @Binds
    fun bindSavedScreen(screen: SavedScreenImpl): SavedScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(SavedScreen::class)
    fun bindSavedScreenToMap(screen: SavedScreen): Any
}
