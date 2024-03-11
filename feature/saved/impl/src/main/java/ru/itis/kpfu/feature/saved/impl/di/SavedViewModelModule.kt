package ru.itis.kpfu.feature.saved.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.core.common.viewmodel.ViewModelKey
import ru.itis.kpfu.feature.saved.impl.presentation.SavedViewModel

@Module
internal interface SavedViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SavedViewModel::class)
    fun bindSavedViewModel(viewModel: SavedViewModel): ViewModel
}
