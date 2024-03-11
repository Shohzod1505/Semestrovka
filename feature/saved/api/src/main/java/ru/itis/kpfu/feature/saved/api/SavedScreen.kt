package ru.itis.kpfu.feature.saved.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

interface SavedScreen: ApplicationScreen {

    operator fun invoke(model: SavedScreenModel): Screen
}
