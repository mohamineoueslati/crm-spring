package com.moh.crmspring.converters;

import com.moh.crmspring.dto.ContactRequest;
import com.moh.crmspring.entities.Address;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;

public class ContactRequestToContact implements Converter<ContactRequest, Contact> {
    private ContactService contactService;

    @Autowired
    @Lazy
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public Contact convert(ContactRequest contactRequest) {
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
