package ks.heydrink.domain

import javax.inject.Inject

class UserNameValidateUseCase @Inject constructor() {
    operator fun invoke(userName: String): Boolean{
        val hasLetter = userName.any { it.isLetter() }
        val hasDigit = userName.any { it.isDigit() }

        return userName.length >= 6 &&
                hasLetter &&
                hasDigit
    }
}