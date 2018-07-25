package com.example.controller.advice.domain.customer.service;

import com.example.controller.advice.domain.customer.domain.Customer;
import com.example.controller.advice.infrastructure.exception.core.EntityNotFoundException;
import com.example.controller.advice.infrastructure.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CustomerService {
    CustomerRepository repository;
    
    public Customer findById(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Integer.toString(id)));
    }
}
