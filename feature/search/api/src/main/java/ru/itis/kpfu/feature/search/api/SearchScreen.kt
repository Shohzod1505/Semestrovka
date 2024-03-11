package ru.itis.kpfu.feature.search.api

import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.core.navigation.ApplicationScreen

interface SearchScreen: ApplicationScreen {

    operator fun invoke(model: SearchScreenModel): Screen
}
