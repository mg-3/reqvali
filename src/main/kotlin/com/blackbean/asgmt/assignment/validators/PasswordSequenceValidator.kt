package com.blackbean.asgmt.assignment.validators

import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Must not contain any sequence of characters immediately followed by the same sequence.
 *
 * @author mgarcia on 4/30/18.
 */
class PasswordSequenceValidator : Validator {

    override fun validate(target: Any?, errors: Errors) {
        if (target is String) {
            
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return String::class == clazz
    }
}