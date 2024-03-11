package ru.itis.kpfu.feature.detail.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey
import ru.itis.kpfu.feature.detail.impl.presentation.DetailViewModel

@Module
internal interface DetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}
