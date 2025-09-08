package ks.heydrink.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ks.heydrink.ui.screens.HomeScreen
import ks.heydrink.ui.screens.ProfileScreen
import ks.heydrink.ui.screens.RatingScreen
import ks.heydrink.ui.screens.ScienceScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController() // navController-управление стеком и переходами

    Scaffold(
        bottomBar = { NavigationBar(navController) }
    ) { padding ->
        NavHost( // контейнер для от-я текущей дестинации из стека
            navController = navController,
            startDestination = "science",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen() }
            composable("rating") { RatingScreen() }
            composable("science") { ScienceScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}