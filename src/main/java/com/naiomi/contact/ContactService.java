package com.naiomi.contact;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface ContactService {

    List<Contact> findAll();

    Contact create(Contact contact);

    boolean existsById(String id);

    Contact findById(String id);

    Contact update(Contact contact);

    void deleteById(String id);

}
