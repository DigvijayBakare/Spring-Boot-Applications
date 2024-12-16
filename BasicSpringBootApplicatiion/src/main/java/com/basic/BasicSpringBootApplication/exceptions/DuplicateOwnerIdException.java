package com.basic.BasicSpringBootApplication.exceptions;

public class DuplicateOwnerIdException extends Exception {
    public DuplicateOwnerIdException(String message) {
        super(message);
    }
}
