package ks.heydrink.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    val onboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted(completed: Boolean)
}