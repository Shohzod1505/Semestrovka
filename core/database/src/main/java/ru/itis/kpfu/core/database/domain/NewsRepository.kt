package ru.itis.kpfu.core.database.domain

import ru.itis.kpfu.core.database.data.entity.NewsEntity

interface NewsRepository {
    suspend fun saveNews(news: NewsEntity)
}
