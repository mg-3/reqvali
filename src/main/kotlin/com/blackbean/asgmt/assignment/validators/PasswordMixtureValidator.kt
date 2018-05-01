package com.blackbean.asgmt.assignment.validators

import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
 *
 * @author mgarcia on 4/30/18.
 */
class PasswordMixtureValidator : Validator {

    val re = Regex("^.*(?=.*\\d)(?=.*[a-z]).*\$")

    override fun validate(target: Any?, errors: Errors) {
        if (target is String) {
            val m = re.matchEntire(target)
            if (m == null) {
                errors.reject("Invalid mixture of password contents")
            }
        }
    }

    override fun supports(clazz: Class<*>): Boolean {
        return String::class == clazz
    }

}