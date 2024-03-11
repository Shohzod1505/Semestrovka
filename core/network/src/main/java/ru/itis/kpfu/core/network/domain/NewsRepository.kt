package ru.itis.kpfu.core.network.domain

import ru.itis.kpfu.core.network.data.response.NewsResponse

interface NewsRepository {

    suspend fun getNews(query: String?): NewsResponse
}
