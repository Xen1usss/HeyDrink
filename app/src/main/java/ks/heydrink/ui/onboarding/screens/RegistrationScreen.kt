package ks.heydrink.ui.onboarding.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.ui.onboarding.OnboardingViewModel

@Composable

fun RegistrationScreen() {

    val viewModel: OnboardingViewModel = hiltViewModel()
    val state: RegistrationState = viewModel.stateFlow.collectAsState().value

    if (!state.isUsernameConfirmed) {
        TakeNameScreen(onNextClick = {}, onBackClick = {}, viewModel = viewModel)
    } else if (!state.isPasswordConfirmed) {
        TakePasswordScreen(onNextClick = {}, onBackClick = {})
    } else {
        TakeAvatarScreen(onNextClick = {}, onBackClick = {})
    }
}
