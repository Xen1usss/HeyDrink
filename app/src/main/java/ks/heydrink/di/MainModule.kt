package ks.heydrink.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ks.heydrink.data.repository.OnboardingRepositoryImpl
import ks.heydrink.domain.repository.OnboardingRepository

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

//    @Binds
//    fun p(q: OnboardingRepositoryImpl) : OnboardingRepository

    @Provides
    fun provideOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository {
        return impl
    }

}