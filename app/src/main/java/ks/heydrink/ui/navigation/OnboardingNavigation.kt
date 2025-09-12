package ks.heydrink.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ks.heydrink.ui.onboarding.screens.Greeting
import ks.heydrink.ui.onboarding.screens.TakeName

@Composable
fun OnboardingNavigation(
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "greeting"
    ) {
        composable("greeting") {
            Greeting(onNextClick = {
                navController.navigate("take_name")
            })
        }
        composable("take_name") {
            TakeName(
                onFinishClick = onFinish,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
