package com.naiomi.customer;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;

import java.util.List;
import java.util.Optional;

@Controller("/customers")
public class CustomerController {

    private final CustomerServiceImp customerService;

    public CustomerController(CustomerServiceImp customerService) {
        this.customerService = customerService;
    }

    @Get("/")
    public List<Customer> list() {
        return customerService.list();
    }

    @Get("/{id}")
    public HttpResponse<?> get(Long id) {
        Optional<Customer> customerOptional = customerService.get(id);
        if(customerOptional.isPresent()){
            return HttpResponse.ok(customerOptional.get());
        }else{
            return HttpResponse.notFound(String.format("Customer with id %d not found", id));
        }
    }

    @Get("/status/{status}")
    public  HttpResponse<?> getCustomerByStatus(@PathVariable("status") String status) {
        if (status == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Status parameter is required");
        } else if (status.equals("ACTIVE") || status.equals("INACTIVE")) {
            return HttpResponse.ok(customerService.listByStatus(status));
        } else {
            return HttpResponse.notFound(String.format("Status %s not found", status));
        }
    }

    @Post("/")
    public Customer create(@Body Customer customer) {
        return customerService.create(customer);
    }

    @Put("/{id}")
    public Customer update(Long id, @Body Customer customer) {
        return customerService.update(id, customer);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        customerService.delete(id);
    }
}
