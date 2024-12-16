package com.basic.BasicSpringBootApplication.exceptions;

public class OwnerNotFoundException extends Exception {
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
