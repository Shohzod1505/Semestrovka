package ru.itis.kpfu.feature.saved.impl.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.navigation.ScreensMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.core.navigation.getScreen
import ru.itis.kpfu.feature.saved.api.SavedScreen

@Module
internal class SavedScreensModule {

    @Provides
    fun provideSavedScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): SavedScreen {
        return screensMap.getScreen()
    }
}
