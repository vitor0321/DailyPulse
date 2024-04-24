package com.walcker.dailypulse.android.di

import com.walcker.dailypulse.articles.ui.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(useCase = get()) }
}