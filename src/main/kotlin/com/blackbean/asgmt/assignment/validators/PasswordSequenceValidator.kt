package com.blackbean.asgmt.assignment.validators

import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Must not contain any sequence of characters immediately followed by the same sequence.
 *
 * @author mgarcia on 4/30/18.
 */
class PasswordSequenceValidator : Validator {

    val re = Regex(".*(\\D+)\\1.*")

    override fun validate(target: Any?, errors: Errors) {
        if (target is String) {
            if (re.matches(target)) {
                errors.reject("Invalid password contents: found same sequence")
            }
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return String::class == clazz
    }
}