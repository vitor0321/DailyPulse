package com.walcker.dailypulse.di

import com.walcker.dailypulse.articles.di.articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule,
)