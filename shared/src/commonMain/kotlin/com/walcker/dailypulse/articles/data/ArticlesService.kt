package com.walcker.dailypulse.articles.data

import com.walcker.dailypulse.articles.domain.models.data.ArticleResponse
import com.walcker.dailypulse.articles.domain.models.data.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ArticlesService(
    private val httpClient: HttpClient
) {
    private val country = listOf("ae","ar","at","au","be","bg","br","ca","ch","cn","co","cu","cz","de","eg","fr","gb","gr","hk").random()
    private val category = listOf("business","entertainment","general","health","science","sports","technology").random()
    private val apiKey = "bf7d6b1711874f368ae2229866fd7d24"

    suspend fun fetchArticles(): List<ArticleResponse> {
        val response: NewsResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}