package com.naiomi.exceptions;

public class StatusNotFoundException extends RuntimeException{

    public StatusNotFoundException(String status) {
        super(status + " not found");
    }
}
