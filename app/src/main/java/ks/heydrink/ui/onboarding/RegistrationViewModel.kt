package ks.heydrink.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ks.heydrink.domain.model.AvatarStep
import ks.heydrink.domain.model.ChangeAvatar
import ks.heydrink.domain.model.ChangePassword
import ks.heydrink.domain.model.NewUsernameIntent
import ks.heydrink.domain.model.CheckUsernameTaken
import ks.heydrink.domain.model.PasswordStep
import ks.heydrink.domain.model.RegistrationIntent
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.domain.model.UsernameStep
import ks.heydrink.domain.repository.OnboardingRepository
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repo: OnboardingRepository) : ViewModel() {

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
            is NewUsernameIntent -> {
                _stateFlow.value = UsernameStep(intent.newUsername, null)
            }

            is ChangePassword -> {
                _stateFlow.value = PasswordStep(intent.newPassword)
            }

            is ChangeAvatar -> {
                _stateFlow.value = AvatarStep(intent.newAvatar)
            }

            CheckUsernameTaken -> TODO()
        }
    }
}