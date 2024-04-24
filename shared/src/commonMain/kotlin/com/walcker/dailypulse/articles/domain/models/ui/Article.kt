package com.walcker.dailypulse.articles.domain.models.ui

data class Article(
    val title: String,
    val subTitle: String?,
    val date: String,
    val imageUrl: String?,
)