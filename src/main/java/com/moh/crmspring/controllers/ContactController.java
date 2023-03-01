package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ContactDto;
import com.moh.crmspring.entities.Address;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactController(ContactService contactService, ModelMapper modelMapper) {
        this.contactService = contactService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ContactDto> getAllContacts() {
        return contactService.findAll().stream().map(c -> modelMapper.map(c, ContactDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ContactDto getContact(@PathVariable Long id) {
        return modelMapper.map(contactService.findById(id), ContactDto.class);
    }

    @PostMapping
    public ContactDto addContact(@Valid @RequestBody ContactDto contactDto) {
        Contact contactOwner = contactService.findById(contactDto.getContactOwnerId());
        Address address = modelMapper.map(contactDto.getAddress(), Address.class);
        Contact contact = modelMapper.map(contactDto, Contact.class);
        contact.setContactOwner(contactOwner);
        address.setContact(contact);
        contact.setAddress(address);

        return modelMapper.map(contactService.save(contact), ContactDto.class);
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
