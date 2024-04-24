package com.walcker.dailypulse.articles.di

import com.walcker.dailypulse.articles.data.ArticlesService
import com.walcker.dailypulse.articles.data.ArticlesUseCaseImpl
import com.walcker.dailypulse.articles.domain.ArticlesUseCase
import com.walcker.dailypulse.articles.ui.ArticlesViewModel
import org.koin.dsl.module

internal val articlesModule = module {

    single<ArticlesService> {
        ArticlesService(
            httpClient = get(),
        )
    }

    single<ArticlesUseCase> {
        ArticlesUseCaseImpl(
            service = get()
        )
    }

    single<ArticlesViewModel> {
        ArticlesViewModel(
            useCase = get()
        )
    }
}