package com.example.controller.advice.rest.controller.customer;

import com.example.controller.advice.domain.customer.domain.Customer;
import com.example.controller.advice.infrastructure.exception.json.ApplicationExceptionAsJSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-07-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void findById_entityExists_code() {
//        expect
        assertThat(restTemplate
                .getForEntity(
                        createURLWithPort("customers/1"),
                        Customer.class)
        .getStatusCode(),is(HttpStatus.OK));
    }

    @Test
    public void findById_entityExists_response() {
//        given
        Customer expectedBody = new Customer(1, "Michal");

//        when
        ResponseEntity<Customer> entity = restTemplate
                .getForEntity(
                        createURLWithPort("customers/1"),
                        Customer.class);

//        then
        assertThat(entity.getBody(), is(expectedBody));
    }

    @Test
    public void findById_entityNotExists_code() {
//        expect
        assertThat(restTemplate
                .getForEntity(
                        createURLWithPort("customers/2"),
                        Customer.class)
                .getStatusCode(),is(HttpStatus.NOT_FOUND));
    }

    @Test
    public void findById_entityNotExists_response() {
//        given
        ApplicationExceptionAsJSON expectedBody = ApplicationExceptionAsJSON.builder()
                .url("/customers/2")
                .message("Entity with id = 2 cannot be found in the database.")
                .build();

//        when
        ResponseEntity<ApplicationExceptionAsJSON> entity = restTemplate
                .getForEntity(
                        createURLWithPort("customers/2"),
                        ApplicationExceptionAsJSON.class);

//        then
        assertThat(entity.getStatusCode(), is(HttpStatus.NOT_FOUND));
        assertThat(entity.getBody(), is(expectedBody));
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}