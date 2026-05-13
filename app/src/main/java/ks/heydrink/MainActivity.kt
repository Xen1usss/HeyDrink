package ks.heydrink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import ks.heydrink.ui.navigation.AppNavigation
import ks.heydrink.ui.navigation.OnboardingNavigation
import ks.heydrink.ui.onboarding.RegistrationViewModel
import ks.heydrink.ui.onboarding.screens.LoadingScreen
import ks.heydrink.ui.theme.HeyDrinkTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeyDrinkTheme {


                val registrationViewModel: RegistrationViewModel = viewModel()

                // подписываемся на состояние
                val onboardingCompleted by registrationViewModel
                    .onboardingCompletedFlow
                    .collectAsState(initial = null)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (onboardingCompleted) {
                        null -> LoadingScreen()
                        false -> OnboardingNavigation(
                            onFinish = {
                                registrationViewModel.completeOnboarding()
                            }
                        )
                        true -> AppNavigation()
                    }
                }
            }
        }
    }
}
