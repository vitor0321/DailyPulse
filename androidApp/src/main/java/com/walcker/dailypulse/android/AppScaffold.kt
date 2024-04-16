package com.walcker.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.walcker.dailypulse.android.screens.AboutScreen
import com.walcker.dailypulse.android.screens.ArticlesScreen
import com.walcker.dailypulse.android.screens.Screens
import com.walcker.dailypulse.articles.ArticlesViewModel

@Composable
internal fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articlesViewModel = articlesViewModel,

            )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    articlesViewModel: ArticlesViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = {
                    navController.navigate(Screens.ABOUT_DEVICE.route)
                },
                articlesViewModel = articlesViewModel
            )
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}