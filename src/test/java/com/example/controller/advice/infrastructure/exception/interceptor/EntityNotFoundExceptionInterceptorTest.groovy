package com.example.controller.advice.infrastructure.exception.interceptor

import com.example.controller.advice.infrastructure.exception.core.EntityNotFoundException
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest
/**
 * Created by mtumilowicz on 2018-07-25.
 */
class EntityNotFoundExceptionInterceptorTest extends Specification {

    def "test entityNotFoundException - validate request param"() {
        given:
        def request = Mock(HttpServletRequest)

        and:
        def exception = Mock(EntityNotFoundException)

        and:
        def interceptor = new EntityNotFoundExceptionInterceptor()

        when:
        interceptor.entityNotFoundException(request, exception)

        then:
        thrown(IllegalArgumentException)
    }

    def "test entityNotFoundException - validate exception param"() {
        given:
        def request = Mock(HttpServletRequest)

        and:
        def exception = Mock(EntityNotFoundException)

        and:
        def interceptor = new EntityNotFoundExceptionInterceptor()

        when:
        interceptor.entityNotFoundException(request, exception)

        then:
        thrown(IllegalArgumentException)
    }
    
    def "test entityNotFoundException"() {
        given:
        def request = Mock(HttpServletRequest) {
            getRequestURI() >> "url"
        }

        and:
        def exception = Mock(EntityNotFoundException) {
            getLocalizedMessage() >> "message"
        }
        
        and:
        def interceptor = new EntityNotFoundExceptionInterceptor()

        when:
        def wrapper = interceptor.entityNotFoundException(request, exception)

        then:
        with(wrapper) {
            url == "url"
            message == "message"
        }
    }
}
