package ru.itis.kpfu.core.network.data.repository

import ru.itis.kpfu.core.network.data.NewsApi
import ru.itis.kpfu.core.network.data.response.NewsResponse
import ru.itis.kpfu.core.network.domain.NewsRepository

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {

    override suspend fun getNews(
        query: String?
    ): NewsResponse = newsApi.getNews(query)

}
