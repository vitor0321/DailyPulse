package com.walcker.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.walcker.dailypulse.articles.domain.models.ui.Article
import com.walcker.dailypulse.articles.ui.ArticlesViewModel
import com.walcker.topaz.ExperimentalTopazComposeLibraryApi
import com.walcker.topaz.components.TopazAsyncImage
import com.walcker.topaz.components.TopazError
import com.walcker.topaz.components.TopazTopAppBar
import com.walcker.topaz.components.TopazVerticalSpacer
import com.walcker.topaz.components.loading.TopazCircularProgress
import com.walcker.topaz.tokens.TopazSpacerSize
import kotlinx.collections.immutable.ImmutableList
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalTopazComposeLibraryApi::class)
@Composable
internal fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel = getViewModel(),
    onAboutButtonClick: () -> Unit,
) {
    val articlesState by articlesViewModel.articlesState.collectAsState()

    Column {
        TopazTopAppBar(
            title = "Articles",
            actions = {
                IconButton(onClick = onAboutButtonClick) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "About Device Button"
                    )
                }
            }
        )
        if (articlesState.loading)
            TopazCircularProgress()
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

@OptIn(ExperimentalTopazComposeLibraryApi::class)
@Composable
private fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TopazAsyncImage(image = article.imageUrl)

        TopazVerticalSpacer()

        Text(
            text = article.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )

        TopazVerticalSpacer(size = TopazSpacerSize.Medium)

        article.subTitle?.let {
            Text(text = it)
        }

        TopazVerticalSpacer()

        Text(
            modifier = Modifier.align(Alignment.End),
            text = article.date,
            style = TextStyle(color = Color.Gray)
        )

        TopazVerticalSpacer()
    }
}
