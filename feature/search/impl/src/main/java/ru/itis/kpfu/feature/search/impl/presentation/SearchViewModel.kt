package ru.itis.kpfu.feature.search.impl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch
import ru.itis.kpfu.core.common.resources.Resources
import ru.itis.kpfu.feature.detail.api.DetailScreen
import ru.itis.kpfu.feature.detail.api.DetailScreenModel
import ru.itis.kpfu.feature.search.impl.domain.GetNewsUseCase
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsItem
import ru.itis.kpfu.feature.search.impl.presentation.mappers.toListAdapterNews
import javax.inject.Inject

internal class SearchViewModel @Inject constructor(
    private val router: Router,
    private val detailScreen: DetailScreen,
    private val resources: Resources,
    private val getNewsUseCase: GetNewsUseCase
    ) : ViewModel() {

    private val query = MutableLiveData<String>()

    fun onNewsClicked(title: String?){
        if (title != null) {
            router.navigateTo(detailScreen.invoke(DetailScreenModel(""), title))
        }
    }

    fun onQueryTextChanged(text: String) {
        query.value = text
    }

    suspend fun getNews(query: String) = getNewsUseCase(query)

}
