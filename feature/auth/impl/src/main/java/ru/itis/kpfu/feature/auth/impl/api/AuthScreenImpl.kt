package ru.itis.kpfu.feature.auth.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.auth.api.AuthScreen
import ru.itis.kpfu.feature.auth.api.AuthScreenModel
import ru.itis.kpfu.feature.auth.impl.presentation.AuthFragment
import javax.inject.Inject

class AuthScreenImpl @Inject constructor(): AuthScreen {

    override fun invoke(model: AuthScreenModel): Screen = FragmentScreen(key = screenKey) {
        AuthFragment.createInstance(model)
    }
}
