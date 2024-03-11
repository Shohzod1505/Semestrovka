package ru.itis.kpfu.feature.detail.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.detail.api.DetailScreen
import ru.itis.kpfu.feature.detail.api.DetailScreenModel
import ru.itis.kpfu.feature.detail.impl.presentation.DetailFragment
import javax.inject.Inject

class DetailScreenImpl @Inject constructor(): DetailScreen {

    override fun invoke(model: DetailScreenModel, query: String): Screen = FragmentScreen(key = screenKey) {
        DetailFragment.createInstance(model, query)
    }
}
