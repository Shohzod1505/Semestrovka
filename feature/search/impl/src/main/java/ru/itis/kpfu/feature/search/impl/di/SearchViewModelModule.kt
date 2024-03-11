package ru.itis.kpfu.feature.search.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey
import ru.itis.kpfu.feature.search.impl.presentation.SearchViewModel

@Module
internal interface SearchViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel
}
