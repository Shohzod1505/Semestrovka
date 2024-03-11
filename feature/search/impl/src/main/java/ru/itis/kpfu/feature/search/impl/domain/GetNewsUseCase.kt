package ru.itis.kpfu.feature.search.impl.domain

import ru.itis.kpfu.core.network.data.response.NewsResponse
import ru.itis.kpfu.core.network.domain.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(
        query: String
    ) : NewsResponse = newsRepository.getNews(query)

}
