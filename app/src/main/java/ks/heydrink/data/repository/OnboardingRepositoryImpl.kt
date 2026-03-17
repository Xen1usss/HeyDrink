package ks.heydrink.data.repository

import kotlinx.coroutines.flow.Flow
import ks.heydrink.data.OnboardingPreferences
import ks.heydrink.domain.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    private val prefs: OnboardingPreferences
) : OnboardingRepository {
    override val onboardingCompleted: Flow<Boolean> = prefs.onboardingCompletedFlow

    override suspend fun setOnboardingCompleted(completed: Boolean) {
        prefs.setOnboardingCompleted(completed)
    }
}