package com.walcker.dailypulse.articles.domain.models.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NewsResponse(
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    val articles: List<ArticleResponse>
)

@Serializable
internal data class ArticleResponse(
    val title: String,
    val description: String?,
    @SerialName("urlToImage")
    val imageUrl: String?,
    @SerialName("publishedAt")
    val date: String,
)