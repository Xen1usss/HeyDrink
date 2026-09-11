package ks.heydrink.ui.onboarding.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ks.heydrink.domain.model.AvatarStep
import ks.heydrink.domain.model.BackClickIntent
import ks.heydrink.domain.model.NextClickIntent
import ks.heydrink.domain.model.PasswordStep
import ks.heydrink.domain.model.RegistrationIntent
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.domain.model.UsernameStep
import ks.heydrink.ui.onboarding.RegistrationViewModel

@Composable

fun RegistrationScreen() {

    val viewModel: RegistrationViewModel = hiltViewModel()
    val state: RegistrationState = viewModel.stateFlow.collectAsState().value

    val newIntentListener: (RegistrationIntent) -> Unit = { intent: RegistrationIntent ->  viewModel.onNewIntent(intent) }

    when (state) {
        is UsernameStep -> {
            TakeNameScreen(
                onNextClick = { viewModel.onNewIntent(NextClickIntent) },
                onBackClick = { viewModel.onNewIntent(BackClickIntent) },
                currentState = state,
                viewModel = viewModel)
        }

        is PasswordStep -> {
            TakePasswordScreen(
                onNextClick = { viewModel.onNewIntent(NextClickIntent) },
                onBackClick = { viewModel.onNewIntent(BackClickIntent) },
                currentState = state,
                сюдаСлатьНовыеИнтенты = viewModel
            )
        }

        is AvatarStep -> {
            TakeAvatarScreen(onNextClick = {}, onBackClick = {})
        }

        else -> {}
    }
}
