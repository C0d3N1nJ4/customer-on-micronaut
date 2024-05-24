package com.naiomi.contact;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Inject
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public boolean existsById(String id) {
        return contactRepository.existsById(id);
    }

    @Override
    public Contact findById(String id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(String id) {
        contactRepository.deleteById(id);
    }


}
