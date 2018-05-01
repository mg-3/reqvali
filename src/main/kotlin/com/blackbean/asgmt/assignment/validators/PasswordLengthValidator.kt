package com.blackbean.asgmt.assignment.validators

import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Must be between 5 and 12 characters in length.
 *
 * @author mgarcia on 4/30/18.
 */
class PasswordLengthValidator : Validator {

    override fun validate(target: Any?, errors: Errors) {
        if (target is String) {
            val len = target.length
            if (len < 5 || len > 12) {
                errors.reject("Invalid password length: $len")
            }
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return String::class == clazz
    }
}