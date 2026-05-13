package ks.heydrink.domain.model

sealed interface RegistrationState

data object Loading : RegistrationState

data class UsernameStep(
    val username: String,
    val isUsernameValid: Boolean? = null,
) : RegistrationState

data class PasswordStep(
    val password: String,
    val isPasswordValid: Boolean? = null,
) : RegistrationState

data class AvatarStep(
    val selectedAvatar: Int = UNSELECTED
) : RegistrationState {
    companion object {
        const val UNSELECTED = -1
    }
}

