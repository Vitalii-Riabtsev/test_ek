package com.rv.ek.nutrition.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super(String.format("Could not find customer ID: %d", id));
    }
}
