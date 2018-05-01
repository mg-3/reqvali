package com.blackbean.asgmt.assignment.controller

import com.blackbean.asgmt.assignment.service.ValidatorService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Controller that ensures the password meets the required criteria
 *
 * @author mgarcia on 4/30/18.
 */
@RestController
class PasswordController(
        @Autowired val validatorService: ValidatorService
) {

    companion object {
        val logger = LoggerFactory.getLogger(PasswordController::class.java.name)
    }

    @RequestMapping(
            value = "/checkpwd",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.TEXT_PLAIN_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun checkPassword(@RequestBody inputText : String, bindingResult: BindingResult) : ResponseEntity<CheckResponse> {
        logger.info("Checking password is valid: $inputText")
        validatorService.checkValidity(inputText, bindingResult)
        return if (bindingResult.hasErrors()) {
            ResponseEntity.ok(CheckResponse(false, bindingResult.allErrors[0].code))
        }
        else {
            ResponseEntity.ok(CheckResponse(true, "confirmed"))
        }
    }

    data class CheckResponse(
            var isValid : Boolean,
            var message : String?
    )

}