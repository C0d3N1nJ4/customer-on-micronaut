package com.naiomi.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    private String id;

    private String street;

    private String number;

    private String suburb;

    private String city;

    private String postalCode;

}
