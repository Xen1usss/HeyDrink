package ks.heydrink.ui.onboarding.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.ui.onboarding.OnboardingViewModel

@Composable

fun RegistrationScreen() {

    val viewModel : OnboardingViewModel
    viewModel = viewModel()
    val state: RegistrationState = viewModel.stateFlow.collectAsState().value

    if (!state.isUsernameConfirmed) {
        TakeName(onNextClick = {}, onBackClick = {})
    } else if (!state.isPasswordConfirmed) {
        TakePassword(onNextClick = {}, onBackClick = {})
    } else {
        TakeAvatar(onNextClick = {}, onBackClick = {})
    }




}