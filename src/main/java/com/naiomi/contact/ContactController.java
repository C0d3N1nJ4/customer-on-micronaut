package com.naiomi.contact;

import com.naiomi.exceptions.ContactNotFoundException;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/contact")
public class ContactController {

    private final ContactService contactService;

    @Inject
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Get
    public List<Contact> getContacts() {
        return contactService.findAll();
    }

    @Get("/{id}")
    public Contact getContactById(@PathVariable String id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            return contact;
        } else {
            throw new ContactNotFoundException(id);
        }
    }
}
