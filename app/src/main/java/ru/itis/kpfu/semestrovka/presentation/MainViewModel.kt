package ru.itis.kpfu.semestrovka.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import ru.itis.kpfu.feature.auth.api.AuthScreen
import ru.itis.kpfu.feature.auth.api.AuthScreenModel
import ru.itis.kpfu.feature.search.api.SearchScreen
import ru.itis.kpfu.feature.search.api.SearchScreenModel
import javax.inject.Inject

internal class MainViewModel @Inject constructor(
    private val router: Router,
    private val cicerone: NavigatorHolder,
    private val authScreen: SearchScreen,
) : ViewModel() {

    init {
        openAuthorization()
    }

    private fun openAuthorization(){
        router.navigateTo(authScreen.invoke(SearchScreenModel("")))
    }

    fun setNavigator(navigator: Navigator) {
        cicerone.setNavigator(navigator)
    }

    fun removeNavigator() {
        cicerone.removeNavigator()
    }
}
