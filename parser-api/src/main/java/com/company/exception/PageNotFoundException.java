package com.company.exception;

public class PageNotFoundException extends Exception {
    public PageNotFoundException() {
    }

    public PageNotFoundException(String message) {
        super(message);
    }
}
