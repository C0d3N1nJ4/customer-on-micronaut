package com.naiomi.customer;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findAll();

    List<Customer> getCustomerByStatus(String status);

    Optional<Customer> findCustomerByAddress_Id(String addressId);
}
