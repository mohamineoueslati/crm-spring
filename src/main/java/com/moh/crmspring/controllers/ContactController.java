package com.moh.crmspring.controllers;

import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact getContact(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public Contact addContact(@Valid @RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping
    public Contact updateContact(@Valid @RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            contactService.delete(contact);
        }
    }
}
