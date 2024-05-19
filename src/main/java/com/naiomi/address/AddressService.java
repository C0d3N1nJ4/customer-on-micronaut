package com.naiomi.address;

import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public interface AddressService {

    Optional<Address> findById(String id);

    Address create(Address address);

    boolean existsById(String id);
}
