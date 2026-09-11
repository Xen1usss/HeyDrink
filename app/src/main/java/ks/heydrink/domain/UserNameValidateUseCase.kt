package ks.heydrink.domain

import ks.heydrink.domain.model.NotEnoughDigit
import ks.heydrink.domain.model.NotEnoughLetter
import ks.heydrink.domain.model.TooShort
import ks.heydrink.domain.model.ValidationFailure
import ks.heydrink.domain.model.ValidationResult
import javax.inject.Inject

class UserNameValidateUseCase @Inject constructor() {

    operator fun invoke(userName: String): ValidationResult {

        val hasLetter = userName.any { it.isLetter() }
        val hasDigit = userName.any { it.isDigit() }
        val longEnough = userName.length > 7

        val listMistake = mutableListOf<ValidationFailure>()

        if (!hasLetter) {
            listMistake.add(element = NotEnoughLetter())
        }
        if (!hasDigit) {
            listMistake.add(element = NotEnoughDigit())
        }
        if (!longEnough) {
            listMistake.add(element = TooShort())
        }

        val validationResult = ValidationResult(listMistake)

        return validationResult
    }
}