package com.naiomi.customer;

import com.naiomi.address.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    private String id;
    private String name;
    private String lastname;
    private String status;

    @OneToOne

    private Address address;

    @OneToOne
    private Contact contact;
}
