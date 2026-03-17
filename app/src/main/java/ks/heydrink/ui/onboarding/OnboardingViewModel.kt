package ks.heydrink.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ks.heydrink.data.repository.OnboardingRepositoryImpl

@HiltViewModel
class OnboardingViewModel(private val repo: OnboardingRepositoryImpl) : ViewModel() {

    // StateFlow — удобно подписываться в Compose через collectAsState()
    val onboardingCompletedFlow: StateFlow<Boolean?> = repo.onboardingCompleted
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun completeOnboarding() {
        viewModelScope.launch {
            repo.setOnboardingCompleted(true)
        }
    }

}