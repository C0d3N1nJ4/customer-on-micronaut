package com.naiomi.address;

import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean existsById(String id) {
        return addressRepository.existsById(id);
    }

    @Override
    public Optional<Address> findById(String id) {
        return addressRepository.findById(id);
    }

    public Iterable<Address> findByCity(String city) {
        return addressRepository.findAddressByCity(city);
    }
}
