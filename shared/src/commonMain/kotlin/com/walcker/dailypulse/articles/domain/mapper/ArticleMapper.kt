package com.walcker.dailypulse.articles.domain.mapper

import com.walcker.dailypulse.articles.domain.models.data.ArticleResponse
import com.walcker.dailypulse.articles.domain.models.ui.Article
import com.walcker.dailypulse.uteis.DateTime.getDaysAgoString

internal object ArticleMapper {
    fun ArticleResponse.toArticle(): Article =
        Article(
            title = title,
            subTitle = description,
            date = getDaysAgoString(date = date),
            imageUrl = imageUrl,
        )
}