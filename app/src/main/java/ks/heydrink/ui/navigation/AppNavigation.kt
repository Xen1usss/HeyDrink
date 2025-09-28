package ks.heydrink.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ks.heydrink.ui.profile.ProfileScreen
import ks.heydrink.ui.research.ArticleDetailScreen
import ks.heydrink.ui.research.ScienceScreen
import ks.heydrink.ui.screens.HomeScreen
import ks.heydrink.ui.screens.RatingScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController() // navController-управление стеком и переходами

    Scaffold(
        bottomBar = { NavigationBar(navController) } // нижняя навигация всегда есть
    ) { padding ->
        NavHost( // контейнер для от-я текущей дестинации из стека
            navController = navController,
            startDestination = "science",
            modifier = Modifier.padding(padding) // учитываем отступы под навбар
        ) {
            composable("home") { HomeScreen() }
            composable("rating") { RatingScreen() }
            composable("science") { ScienceScreen(navController) }
            composable("profile") { ProfileScreen() }

            composable(
                route = "article/{articleId}",
                arguments = listOf(navArgument("articleId") { type = NavType.StringType })
            ) { backStackEntry ->
                val articleId = backStackEntry.arguments?.getString("articleId")
                ArticleDetailScreen(articleId = articleId, navController = navController)
            }
        }
    }
}