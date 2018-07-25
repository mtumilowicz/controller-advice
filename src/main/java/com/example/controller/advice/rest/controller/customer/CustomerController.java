package com.example.controller.advice.rest.controller.customer;

import com.example.controller.advice.domain.customer.domain.Customer;
import com.example.controller.advice.domain.customer.service.CustomerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService service;

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("customers/health")
    public void health() {

    }
}
