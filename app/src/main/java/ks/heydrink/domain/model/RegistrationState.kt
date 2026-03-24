package ks.heydrink.domain.model

data class RegistrationState(
    val isUsernameConfirmed: Boolean = false,
    val isPasswordConfirmed: Boolean = false,
    val usernameText: String,
    val isLoading: Boolean,
    val isUsernameValid: Boolean? = null,
    val passwordText: String,
    val isVisible: Boolean,
    val selectedAvatar: Int
)
