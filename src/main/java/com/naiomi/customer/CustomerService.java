package com.naiomi.customer;

import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public interface CustomerService {

    Iterable<Customer> findAll();

    boolean existsById(String id);

    Optional<Customer> findById(String id);

    List<Customer> getCustomerByStatus(String status);

    Customer createCustomer(Customer customer);
}
