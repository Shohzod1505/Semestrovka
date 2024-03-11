package ru.itis.kpfu.feature.auth.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

interface AuthScreen: ApplicationScreen {

    operator fun invoke(model: AuthScreenModel): Screen
}
