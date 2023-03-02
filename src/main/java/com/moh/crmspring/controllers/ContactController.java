package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ContactDto;
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
    public List<ContactDto> getAllContacts() {
        return contactService.findAll().stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ContactDto getContact(@PathVariable Long id) {
        return new ContactDto(contactService.findById(id));
    }

    @PostMapping
    public ContactDto addContact(@Valid @RequestBody ContactDto contactDto) {
        Contact contact = contactDtoToContact(contactDto);
        return new ContactDto(contactService.save(contact));
    }

    @PutMapping
    public ContactDto updateContact(@Valid @RequestBody ContactDto contactDto) {
        Contact contact = contactDtoToContact(contactDto);
        return new ContactDto(contactService.save(contact));
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) contactService.delete(contact);
    }

    private Contact contactDtoToContact(ContactDto contactDto) {
        Contact contact = new Contact(contactDto);
        Contact contactOwner = null;
        if (contactDto.getContactOwnerId() != null)
            contactOwner = contactService.findById(contactDto.getContactOwnerId());
        contact.setContactOwner(contactOwner);
        Address address = contact.getAddress();
        if (address != null) address.setContact(contact);

        return contact;
    }
}
