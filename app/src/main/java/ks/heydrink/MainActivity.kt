package ks.heydrink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ks.heydrink.ui.navigation.AppNavigation
import ks.heydrink.ui.navigation.OnboardingNavigation
import ks.heydrink.ui.theme.HeyDrinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeyDrinkTheme {
                // Состояние: показывать онбординг или основной экран
                var showOnboarding by remember { mutableStateOf(true) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (showOnboarding) {
                        OnboardingNavigation( // Показываем онбординг
                            onFinish = {
                                showOnboarding = false
                            }
                        )
                    } else {
                        AppNavigation() // Показываем основную навигацию
                    }
                }
            }
        }
    }
}
