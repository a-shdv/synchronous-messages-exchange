package com.company.exceptions;

public class JobAlreadyExistsException extends Exception {
    public JobAlreadyExistsException() {
    }

    public JobAlreadyExistsException(String message) {
        super(message);
    }
}
