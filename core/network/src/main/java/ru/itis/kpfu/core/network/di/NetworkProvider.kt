package ru.itis.kpfu.core.network.di

import ru.itis.kpfu.core.network.domain.NewsRepository

interface NetworkProvider {

    fun provideNewsRepository(): NewsRepository

}
