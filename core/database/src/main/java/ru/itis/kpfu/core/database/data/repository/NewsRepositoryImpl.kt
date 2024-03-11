package ru.itis.kpfu.core.database.data.repository

import ru.itis.kpfu.core.database.data.dao.NewsDao
import ru.itis.kpfu.core.database.data.entity.NewsEntity
import ru.itis.kpfu.core.database.domain.NewsRepository
import javax.inject.Inject

internal class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun saveNews(news: NewsEntity) {
        newsDao.save(news)
    }

}
