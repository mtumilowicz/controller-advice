package com.example.controller.advice.domain.customer.service

import com.example.controller.advice.domain.customer.domain.Customer
import com.example.controller.advice.infrastructure.exception.core.EntityNotFoundException
import com.example.controller.advice.infrastructure.repository.CustomerRepository
import spock.lang.Specification
/**
 * Created by mtumilowicz on 2018-07-25.
 */
class CustomerServiceTest extends Specification {
    def "test findById - entity found"() {
        given:
        def _customer = new Customer(1, "firstName")

        and:
        def repository = Mock(CustomerRepository) {
            findById(1) >> Optional.of(_customer)
        }
        
        and:
        def service = new CustomerService(repository)

        expect:
        service.findById(1) == _customer
    }

    def "test findById - entity not found"() {
        given:
        def repository = Mock(CustomerRepository) {
            findById(_) >> Optional.empty()
        }

        and:
        def service = new CustomerService(repository)

        when:
        service.findById(1)
        
        then:
        thrown(EntityNotFoundException)
    }
}
