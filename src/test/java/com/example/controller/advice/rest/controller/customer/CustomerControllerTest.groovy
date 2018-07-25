package com.example.controller.advice.rest.controller.customer

import com.example.controller.advice.domain.customer.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-25.
 */
class CustomerControllerTest extends Specification {
    def "test findById"() {
        given:
        def service = Mock(CustomerService)
        
        and:
        def controller = new CustomerController(service)
        
        when:
        controller.findById(1)
        
        then:
        1 * service.findById(1)
    }
}
