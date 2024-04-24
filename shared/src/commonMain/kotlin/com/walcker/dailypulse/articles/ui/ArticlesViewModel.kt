package com.walcker.dailypulse.articles.ui

import com.walcker.dailypulse.BaseViewModel
import com.walcker.dailypulse.articles.domain.ArticlesUseCase
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase,
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()
            _articlesState.emit(
                ArticlesState(
                    articles = fetchedArticles.toImmutableList(),
                    loading = false
                )
            )
        }
    }
}