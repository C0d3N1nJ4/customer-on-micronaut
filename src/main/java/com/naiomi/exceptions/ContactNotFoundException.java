package com.naiomi.exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message) {
        super("Could not find contact " + message);
    }
}
