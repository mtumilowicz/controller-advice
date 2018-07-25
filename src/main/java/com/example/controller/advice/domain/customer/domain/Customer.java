package com.example.controller.advice.domain.customer.domain;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@Entity
@Value
public class Customer implements Serializable {
    @Id
    private Integer id;
    private String firstName;
}
