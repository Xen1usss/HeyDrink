package ks.heydrink.ui.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ks.heydrink.domain.model.AvatarStep
import ks.heydrink.domain.model.BackClickIntent
import ks.heydrink.domain.model.ChangeAvatarIntent
import ks.heydrink.domain.model.ChangePasswordIntent
import ks.heydrink.domain.model.ChangeUsernameIntent
import ks.heydrink.domain.model.CheckUsernameTakenIntent
import ks.heydrink.domain.model.NextClickIntent
import ks.heydrink.domain.model.PasswordStep
import ks.heydrink.domain.model.RegistrationIntent
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.domain.model.UsernameStep
import ks.heydrink.domain.repository.OnboardingRepository
import ks.heydrink.ui.onboarding.screens.CanProcessIntent
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repo: OnboardingRepository) : ViewModel(), CanProcessIntent {

    val onboardingCompletedFlow: StateFlow<Boolean?> = repo.onboardingCompleted
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    private val _stateFlow = MutableStateFlow<RegistrationState>(UsernameStep(""))
    val stateFlow: StateFlow<RegistrationState> = _stateFlow

    fun completeOnboarding() {
        viewModelScope.launch {
            repo.setOnboardingCompleted(true)
        }
    }

    fun onNewIntent(intent: RegistrationIntent) {
        when (intent) {
            is ChangeUsernameIntent -> {
                _stateFlow.value = UsernameStep(intent.newUsername, null)
            }

            is ChangePasswordIntent -> {
                _stateFlow.value = PasswordStep(intent.newPassword)
            }

            is ChangeAvatarIntent -> {
                _stateFlow.value = AvatarStep(intent.newAvatar)
            }

            is NextClickIntent -> {
                if (_stateFlow.value is UsernameStep) {
                    val passwordStep: PasswordStep = PasswordStep("")
                    _stateFlow.value = passwordStep
                } else if (_stateFlow.value is PasswordStep){
                    val avatarStep: AvatarStep = AvatarStep()
                    _stateFlow.value = avatarStep
                } else {
                    Log.d("RegistrationViewModel","NextClickIntent mistake")
                }
            }

            is BackClickIntent -> {
                if (_stateFlow.value is PasswordStep) {
                    _stateFlow.value = UsernameStep("")
                }
            }

            CheckUsernameTakenIntent -> TODO()
        }
    }

    override fun processIntent(intent: RegistrationIntent) {
        onNewIntent(intent)
    }
}