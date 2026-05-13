package ks.heydrink.domain.model

sealed interface RegistrationIntent

data object CheckUsernameTaken: RegistrationIntent

data class NewUsernameIntent(
    val newUsername: String,
): RegistrationIntent

data class ChangePassword(
    val newPassword: String,
):  RegistrationIntent

data class ChangeAvatar(
    val newAvatar: Int,
):  RegistrationIntent
