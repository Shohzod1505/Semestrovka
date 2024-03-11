package ru.itis.kpfu.feature.detail.impl.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.navigation.ScreensMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.core.navigation.getScreen
import ru.itis.kpfu.feature.detail.api.DetailScreen

@Module
internal class DetailScreensModule {

    @Provides
    fun provideAuthScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): DetailScreen {
        return screensMap.getScreen()
    }
}
