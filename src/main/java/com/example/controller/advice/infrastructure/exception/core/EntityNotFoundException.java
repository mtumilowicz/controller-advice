package com.example.controller.advice.infrastructure.exception.core;

import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-25.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(@NonNull String id) {
        super("Entity with id = " + id + " cannot be found in the database.");
    }
}
