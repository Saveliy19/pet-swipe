package com.saveliy.petswipe.exception;

public class ResourceDoesntExistsException extends RuntimeException {
    public ResourceDoesntExistsException(String message) {
        super(message);
    }
}