package com.walcker.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.walcker.dailypulse.android.topazDesigner.components.TopazError
import com.walcker.dailypulse.android.topazDesigner.components.TopazDividerVertical
import com.walcker.dailypulse.android.topazDesigner.components.TopazLoading
import com.walcker.dailypulse.android.topazDesigner.components.TopazTopAppBar
import com.walcker.dailypulse.android.topazDesigner.tokens.TopazDividerSize
import com.walcker.dailypulse.articles.Article
import com.walcker.dailypulse.articles.ArticlesViewModel
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel,
) {
    val articlesState by articlesViewModel.articlesState.collectAsState()

    Column {
        TopazTopAppBar(title = "Articles")
        if (articlesState.loading)
            TopazLoading()
        articlesState.error?.let { message ->
            TopazError(message = message)
        }
        articlesState.articles.isNotEmpty().let {
            ArticlesListView(articles = articlesState.articles)
        }
    }
}


@Composable
private fun ArticlesListView(articles: ImmutableList<Article>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(articles) { article ->
            ArticleItemView(article = article)
        }
    }
}

@Composable
private fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
        )
        TopazDividerVertical()
        Text(
            text = article.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
        TopazDividerVertical(size = TopazDividerSize.Medium)
        Text(text = article.description)
        TopazDividerVertical()
        Text(
            modifier = Modifier.align(Alignment.End),
            text = article.date,
            style = TextStyle(color = Color.Gray)
        )
        TopazDividerVertical()
    }
}
