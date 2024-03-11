package ru.itis.kpfu.core.network.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.itis.kpfu.core.network.data.response.NewsResponse

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("q") query: String?
    ): NewsResponse

}
