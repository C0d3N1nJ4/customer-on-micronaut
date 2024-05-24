package com.naiomi.contact;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
