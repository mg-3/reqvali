package com.blackbean.asgmt.assignment

import org.springframework.context.MessageSource
import org.springframework.context.MessageSourceAware
import org.springframework.context.support.ResourceBundleMessageSource
import javax.annotation.PostConstruct

/**
 * @author mgarcia on 4/30/18.
 */
class ApplicationMessages(
        private val msgSource: MessageSource = ResourceBundleMessageSource()

) : MessageSourceAware {

    @PostConstruct
    override fun setMessageSource(messageSource: MessageSource) {
        (this.msgSource as ResourceBundleMessageSource).setBasename("messages")
    }


}