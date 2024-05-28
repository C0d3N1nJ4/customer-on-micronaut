package com.naiomi.customer;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> findAllByStatus(String status);
}
