package ru.itis.kpfu.feature.detail.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

interface DetailScreen: ApplicationScreen {

    operator fun invoke(model: DetailScreenModel, query: String): Screen
}
