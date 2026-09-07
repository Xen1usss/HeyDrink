package ks.heydrink.domain.model

sealed interface RegistrationIntent

data object CheckUsernameTakenIntent: RegistrationIntent

data class ChangeUsernameIntent(
    val newUsername: String,
): RegistrationIntent

data class ChangePasswordIntent(
    val newPassword: String,
):  RegistrationIntent

data class ChangeAvatarIntent(
    val newAvatar: Int,
):  RegistrationIntent

data object NextClickIntent: RegistrationIntent

data object BackClickIntent: RegistrationIntent