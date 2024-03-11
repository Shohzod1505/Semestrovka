package ru.itis.kpfu.feature.search.impl.api

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.itis.kpfu.feature.search.api.SearchScreen
import ru.itis.kpfu.feature.search.api.SearchScreenModel
import ru.itis.kpfu.feature.search.impl.presentation.SearchFragment
import javax.inject.Inject

class SearchScreenImpl @Inject constructor(): SearchScreen {

    override fun invoke(model: SearchScreenModel): Screen = FragmentScreen(key = screenKey) {
        SearchFragment.createInstance(model)
    }
}
