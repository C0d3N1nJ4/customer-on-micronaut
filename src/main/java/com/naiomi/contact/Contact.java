package com.naiomi.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    private String id;

    private String email;

    private String phone;
}

