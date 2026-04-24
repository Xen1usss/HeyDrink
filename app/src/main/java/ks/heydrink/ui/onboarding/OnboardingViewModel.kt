
package ks.heydrink.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ks.heydrink.domain.model.RegistrationState
import ks.heydrink.domain.repository.OnboardingRepository
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val repo: OnboardingRepository) : ViewModel() {

    val onboardingCompletedFlow: StateFlow<Boolean?> = repo.onboardingCompleted
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    private val _stateFlow = MutableStateFlow(RegistrationState())
    val stateFlow: StateFlow<RegistrationState> = _stateFlow

    fun completeOnboarding() {
        viewModelScope.launch {
            repo.setOnboardingCompleted(true)
        }
    }

}