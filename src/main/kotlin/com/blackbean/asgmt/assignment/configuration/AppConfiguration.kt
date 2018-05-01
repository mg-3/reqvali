package com.blackbean.asgmt.assignment.configuration

import com.blackbean.asgmt.assignment.validators.PasswordLengthValidator
import com.blackbean.asgmt.assignment.validators.PasswordMixtureValidator
import com.blackbean.asgmt.assignment.validators.PasswordSequenceValidator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.Validator

/**
 * @author mgarcia on 4/30/18.
 */
@Configuration
class AppConfiguration {

    @Bean
    fun lengthValidator() : Validator {
        return PasswordLengthValidator()
    }

    @Bean
    fun mixtureValidator() : Validator {
        return PasswordMixtureValidator()
    }

    @Bean
    fun sequenceValidator() : Validator {
        return PasswordSequenceValidator()
    }
}