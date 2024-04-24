package com.walcker.dailypulse.articles.domain

import com.walcker.dailypulse.articles.domain.models.ui.Article
import kotlinx.collections.immutable.ImmutableList

interface ArticlesUseCase {
    suspend fun getArticles(): ImmutableList<Article>
}