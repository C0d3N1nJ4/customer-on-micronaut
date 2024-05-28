package com.naiomi.customer;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class CustomerServiceImp implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> list() {
       return customerRepository.findAll();
    }

    @Override
    public @NonNull Optional<Customer> get(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public HttpResponse<?> listByStatus(String status) {
        if (status == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Status parameter is required");
        } else if (status.equals("ACTIVE") || status.equals("INACTIVE")) {
            return HttpResponse.ok(customerRepository.findAllByStatus(status));
        } else {
            return HttpResponse.notFound(String.format("Status %s not found", status));
        }
    }
}
