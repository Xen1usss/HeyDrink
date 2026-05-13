package ks.heydrink.ui.onboarding.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ks.heydrink.domain.model.AvatarStep
import ks.heydrink.domain.model.PasswordStep
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.domain.model.UsernameStep
import ks.heydrink.ui.onboarding.RegistrationViewModel

@Composable

fun RegistrationScreen() {

    val viewModel: RegistrationViewModel = hiltViewModel()
    val state: RegistrationState = viewModel.stateFlow.collectAsState().value

    when (state) {
        is UsernameStep -> {
            TakeNameScreen(onNextClick = {}, onBackClick = {}, currentState = state, viewModel = viewModel)
        }

        is PasswordStep -> {
            TakePasswordScreen(onNextClick = {}, onBackClick = {})
        }

        is AvatarStep -> {
            TakeAvatarScreen(onNextClick = {}, onBackClick = {})
        }

        else -> {}
    }
}
