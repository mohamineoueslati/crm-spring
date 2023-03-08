package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ActivityResponse;
import com.moh.crmspring.dto.ContactRequest;
import com.moh.crmspring.dto.ContactResponse;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ActivityService;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactService contactService;
    private final ActivityService activityService;
    private final ConversionService conversionService;

    @Autowired
    public ContactController(ContactService contactService, ActivityService activityService, ConversionService conversionService) {
        this.contactService = contactService;
        this.activityService = activityService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<ContactResponse> getAllContacts() {
        return contactService.findAll().stream()
                .map(contact -> conversionService.convert(contact, ContactResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ContactResponse getContact(@PathVariable Long id) {
        return conversionService.convert(contactService.findById(id), ContactResponse.class);
    }

    @GetMapping("{id}/activities")
    public List<ActivityResponse> getContactActivities(@PathVariable Long id) {
        return activityService.findActivitiesByParticipantId(id).stream().map(ActivityResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ContactResponse addContact(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contact = conversionService.convert(contactRequest, Contact.class);
        return conversionService.convert(contactService.save(contact), ContactResponse.class);
    }

    @PutMapping
    public ContactResponse updateContact(@Valid @RequestBody ContactRequest contactRequest) {
        Contact contact = conversionService.convert(contactRequest, Contact.class);
        return conversionService.convert(contactService.save(contact), ContactResponse.class);
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        contactService.delete(contact);
    }
}
