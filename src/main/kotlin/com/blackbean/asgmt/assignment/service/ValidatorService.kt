package com.blackbean.asgmt.assignment.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.validation.BindingResult
import org.springframework.validation.Validator

/**
 * Service implementation for validating passwords
 *
 * @author mgarcia on 4/30/18.
 */
@Service
class ValidatorService(
        @Autowired @Qualifier("lengthValidator") val lengthValidator: Validator,
        @Autowired @Qualifier("mixtureValidator") val mixtureValidator: Validator,
        @Autowired @Qualifier("sequenceValidator") val sequenceValidator: Validator
) {

    /**
     * Do the validations
     *
     * @param input the sent password
     * @param errors the collection of validation errors if any
     */
    fun checkValidity(input: String, errors: BindingResult) {
        lengthValidator.validate(input, errors)
        mixtureValidator.validate(input, errors)
//        sequenceValidator.validate(input, errors)
    }
}
