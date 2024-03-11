package ru.itis.kpfu.feature.saved.impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.saved.api.SavedScreenModel
import javax.inject.Inject

internal class SavedViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: SavedScreenModel,
) : ViewModel()
