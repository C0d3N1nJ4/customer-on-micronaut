package com.naiomi.exceptions;

public class CustomerNotFoundException  extends RuntimeException{

    public CustomerNotFoundException(Long id){
        super("Customer not found with id: " + id);
    }
}
