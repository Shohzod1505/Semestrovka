package ru.itis.kpfu.feature.search.impl.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.navigation.ScreensMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.core.navigation.getScreen
import ru.itis.kpfu.feature.detail.api.DetailScreen
import ru.itis.kpfu.feature.search.api.SearchScreen

@Module
internal class SearchScreensModule {

    @Provides
    fun provideSearchScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): SearchScreen {
        return screensMap.getScreen()
    }

    @Provides
    fun provideDetailScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): DetailScreen {
        return screensMap.getScreen()
    }

}
