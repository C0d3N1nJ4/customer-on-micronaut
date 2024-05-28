package com.naiomi.customer;

import io.micronaut.core.annotation.NonNull;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> list();

    @NonNull Optional<Customer> get(Long id);

    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);
}
