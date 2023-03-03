package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ContactRequest;
import com.moh.crmspring.dto.ContactResponse;
import com.moh.crmspring.entities.Address;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactResponse> getAllContacts() {
        return contactService.findAll().stream().map(ContactResponse::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ContactResponse getContact(@PathVariable Long id) {
        return new ContactResponse(contactService.findById(id));
    }

    @PostMapping
    public ContactResponse addContact(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contact = contactRequestToContact(contactRequest);
        return new ContactResponse(contactService.save(contact));
    }

    @PutMapping
    public ContactResponse updateContact(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contact = contactRequestToContact(contactRequest);
        return new ContactResponse(contactService.save(contact));
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) contactService.delete(contact);
    }

    private Contact contactRequestToContact(ContactRequest contactRequest) {
        Contact contact = new Contact(contactRequest);
        Contact contactOwner = null;
        if (contactRequest.getContactOwnerId() != null)
            contactOwner = contactService.findById(contactRequest.getContactOwnerId());
        contact.setContactOwner(contactOwner);
        Address address = contact.getAddress();
        if (address != null) address.setContact(contact);

        return contact;
    }
}
