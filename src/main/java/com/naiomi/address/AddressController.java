package com.naiomi.address;

import com.naiomi.exceptions.AddressNotFoundException;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import java.util.Optional;

@Validated
@Controller("/address")
public class AddressController {

    private final AddressServiceImpl addressService;

    @Inject
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @Get("/{address-id}")
    @Status(HttpStatus.OK)
    public Optional<Address> getAddressById(@PathVariable("address-id") String id) {
        if (addressService.existsById(id)) {
            return addressService.findById(id);
        } else {
            throw new AddressNotFoundException(id);
        }
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Address createAddress(@Body Address address) {
        return addressService.create(address);
    }

    @Get("/filter/city/{city}")
    public Iterable<Address> getAddressByCity(@PathVariable("city") String city) {
        if (city == null) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        } else {
            return addressService.findByCity(city);
        }
    }
}
