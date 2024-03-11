package ru.itis.kpfu.core.navigation

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface NavigationProvider {

    fun provideRouter(): Router

    fun provideNavigatorHolder(): NavigatorHolder
}
