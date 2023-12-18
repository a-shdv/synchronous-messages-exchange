package com.company.exceptions;

public class JobNotFoundException extends Exception {
    public JobNotFoundException() {
    }

    public JobNotFoundException(String message) {
        super(message);
    }
}
