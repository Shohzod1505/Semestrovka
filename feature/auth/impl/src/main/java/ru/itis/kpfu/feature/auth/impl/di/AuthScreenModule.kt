package ru.itis.kpfu.feature.auth.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.navigation.ScreensQualifier
import ru.itis.kpfu.feature.auth.api.AuthScreen
import ru.itis.kpfu.feature.auth.impl.api.AuthScreenImpl

@Module
interface AuthScreenModule {

    @Binds
    fun bindAuthScreen(screen: AuthScreenImpl): AuthScreen

    @Binds
    @IntoMap
    @ScreensQualifier
    @ClassKey(AuthScreen::class)
    fun bindAuthScreenToMap(screen: AuthScreen): Any
}
