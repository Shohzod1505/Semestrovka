package ru.itis.kpfu.feature.saved.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.saved.api.SavedScreen
import ru.itis.kpfu.feature.saved.api.SavedScreenModel
import ru.itis.kpfu.feature.saved.impl.presentation.SavedFragment
import javax.inject.Inject

class SavedScreenImpl @Inject constructor(): SavedScreen {

    override fun invoke(model: SavedScreenModel): Screen = FragmentScreen(key = screenKey) {
        SavedFragment.createInstance(model)
    }
}
