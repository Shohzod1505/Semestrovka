package ru.itis.kpfu.feature.auth.impl.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.core.navigation.ScreensMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.core.navigation.getScreen
import ru.itis.kpfu.feature.auth.api.AuthScreen

@Module
internal class AuthScreensModule {

    @Provides
    fun provideAuthScreen(
        @ScreensQualifier screensMap: ScreensMap
    ): AuthScreen {
        return screensMap.getScreen()
    }
}
