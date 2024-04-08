package com.walcker.dailypulse.articles

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal class ArticlesState(
    val article: ImmutableList<Article> = persistentListOf(),
    val loading: Boolean = true,
    val error: String? = null,
)