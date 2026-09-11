package ks.heydrink.domain.model

interface ValidationFailure {

}

data class ValidationResult (
    val failures: List<ValidationFailure>
) {
    val isSuccess: Boolean
        get() = failures.isEmpty()
}

class NotEnoughDigit: ValidationFailure {

}

class NotEnoughLetter: ValidationFailure {

}

class TooShort: ValidationFailure {

}