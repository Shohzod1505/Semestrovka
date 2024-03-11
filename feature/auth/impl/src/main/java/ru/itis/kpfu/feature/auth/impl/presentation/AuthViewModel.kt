package ru.itis.kpfu.feature.auth.impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.auth.api.AuthScreenModel
import javax.inject.Inject

internal class AuthViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: AuthScreenModel,
) : ViewModel()
