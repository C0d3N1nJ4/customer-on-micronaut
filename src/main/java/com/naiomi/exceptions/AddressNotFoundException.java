package com.naiomi.exceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message) {
        super("Address with id " + message + " not found");
    }
}
