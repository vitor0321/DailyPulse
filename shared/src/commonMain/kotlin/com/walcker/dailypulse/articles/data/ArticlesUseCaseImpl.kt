package com.walcker.dailypulse.articles.data

import com.walcker.dailypulse.articles.domain.ArticlesUseCase
import com.walcker.dailypulse.articles.domain.mapper.ArticleMapper.toArticle
import com.walcker.dailypulse.articles.domain.models.ui.Article
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal class ArticlesUseCaseImpl(
    private val service: ArticlesService
) : ArticlesUseCase {

    override suspend fun getArticles(): ImmutableList<Article> =
        service.fetchArticles().map { it.toArticle() }.toImmutableList()
}