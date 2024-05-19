package com.naiomi.address;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String>{
    List<Address> findAddressByCity(String city);
}
