package com.example.controller.advice.infrastructure.repository;

import com.example.controller.advice.domain.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
