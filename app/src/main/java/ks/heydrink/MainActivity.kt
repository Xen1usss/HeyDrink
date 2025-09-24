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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import ks.heydrink.data.OnboardingPreferences
import ks.heydrink.data.repository.OnboardingRepositoryImpl
import ks.heydrink.ui.navigation.AppNavigation
import ks.heydrink.ui.navigation.OnboardingNavigation
import ks.heydrink.ui.onboarding.OnboardingViewModel
import ks.heydrink.ui.onboarding.screens.LoadingScreen
import ks.heydrink.ui.theme.HeyDrinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeyDrinkTheme {

                // внутри setContent { HeyDrinkTheme { ... } }
                val prefs =
                    OnboardingPreferences(applicationContext) // использует context.dataStore
                val repository = OnboardingRepositoryImpl(prefs)

                val onboardingViewModel: OnboardingViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            @Suppress("UNCHECKED_CAST")
                            return OnboardingViewModel(repository) as T
                        }
                    }
                )

                // подписываемся на состояние
                val onboardingCompleted by onboardingViewModel
                    .onboardingCompletedFlow
                    .collectAsState(initial = null)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (onboardingCompleted) {
                        null -> LoadingScreen()
                        false -> OnboardingNavigation(
                            onFinish = {
                                onboardingViewModel.completeOnboarding()
                            }
                        )
                        true -> AppNavigation()
                    }
                }
            }
        }
    }
}
