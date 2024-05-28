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
    public List<Customer> getListOfCustomers() {
        return customerService.list();
    }

    @Get("/{id}")
    public HttpResponse<?> getCustomerById(Long id) {
        Optional<Customer> customer = customerService.get(id);
        if(customer.isPresent()){
            return HttpResponse.ok(customer.get());
        }else{
            return HttpResponse.notFound(String.format("Customer with id %d not found", id));
        }
    }

    @Get("/status/{status}")
    public   HttpResponse<?> getCustomerByStatus(@PathVariable("status") String status) {
            return customerService.listByStatus(status);
    }

    @Post("/")
    public Customer createCustomer(@Body Customer customer) {
        return customerService.create(customer);
    }

    @Put("/{id}")
    public Customer updateExistingCustomer(Long id, @Body Customer customer) {
        Optional<Customer> existingCustomer = customerService.get(id);
        if(existingCustomer.isEmpty()){
            throw new HttpStatusException(HttpStatus.NOT_FOUND, String.format("Customer with id %d not found", id));
        } else {
            return customerService.update(id, customer);
        }
    }

    @Delete("/{id}")
    public void deleteCustomer(Long id) {
        customerService.delete(id);
    }
}
