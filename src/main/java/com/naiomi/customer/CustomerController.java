package com.naiomi.customer;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

@Validated
@Controller("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Get
    @Status(HttpStatus.OK)
    public Iterable<Customer> getAllCustomers() {
        return customerService.findAll();
    }

}
