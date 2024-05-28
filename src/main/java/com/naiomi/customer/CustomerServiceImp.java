package com.naiomi.customer;

import io.micronaut.core.annotation.NonNull;
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

    public List<Customer> listByStatus(String status) {
        return customerRepository.findAllByStatus(status);
    }
}
