package ru.itis.kpfu.feature.detail.impl.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.detail.api.DetailScreenModel
import ru.itis.kpfu.feature.detail.impl.domain.GetNewsUseCase
import javax.inject.Inject

internal class DetailViewModel @Inject constructor(
    private val router: Router,
    private val resources: Resources,
    private val model: DetailScreenModel,
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {

    suspend fun getNews(query: String) = getNewsUseCase(query)

}
