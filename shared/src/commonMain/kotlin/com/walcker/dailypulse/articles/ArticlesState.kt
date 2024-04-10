package com.walcker.dailypulse.articles

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class ArticlesState(
    val articles: ImmutableList<Article> = persistentListOf(),
    val loading: Boolean = true,
    val error: String? = null,
)