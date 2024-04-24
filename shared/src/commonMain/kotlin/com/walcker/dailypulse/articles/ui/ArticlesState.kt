package com.walcker.dailypulse.articles.ui

import com.walcker.dailypulse.articles.domain.models.ui.Article
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

public class ArticlesState(
    val articles: ImmutableList<Article> = persistentListOf(),
    val loading: Boolean = true,
    val error: String? = null,
)