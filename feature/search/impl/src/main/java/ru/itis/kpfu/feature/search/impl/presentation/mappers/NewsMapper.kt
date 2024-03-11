package ru.itis.kpfu.feature.search.impl.presentation.mappers

import ru.itis.kpfu.core.network.data.response.Article
import ru.itis.kpfu.core.network.data.response.Source
import ru.itis.kpfu.feature.search.impl.presentation.adapter.NewsItem

fun Source.toAdapterSource(): NewsItem.Source = NewsItem.Source(
    category = category,
    country = country,
    description = description,
    id = id,
    language = language,
    name = name,
    url = url
)

fun List<Source>.toListAdapterSource(): List<NewsItem.Source> = map {
    it.toAdapterSource()
}

fun Article.toAdapterArticle(): NewsItem.News = NewsItem.News(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    source = source,
    title = title,
    url = url,
    urlToImage = urlToImage
)

fun List<Article>.toListAdapterNews(): List<NewsItem.News> = map {
    it.toAdapterArticle()
}
