package ru.itis.kpfu.semestrovka.di

import dagger.Module
import ru.itis.kpfu.feature.auth.impl.di.AuthScreenModule
import ru.itis.kpfu.feature.detail.impl.di.DetailScreenModule
import ru.itis.kpfu.feature.saved.impl.di.SavedScreenModule
import ru.itis.kpfu.feature.search.impl.di.SearchScreenModule

@Module(
    includes = [
        AuthScreenModule::class,
        SearchScreenModule::class,
        DetailScreenModule::class,
        SavedScreenModule::class,
    ]
)
internal interface ScreensBinding
