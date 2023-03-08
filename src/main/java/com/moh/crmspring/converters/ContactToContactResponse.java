package com.moh.crmspring.converters;

import com.moh.crmspring.dto.ContactResponse;
import com.moh.crmspring.entities.Contact;
import org.springframework.core.convert.converter.Converter;

public class ContactToContactResponse implements Converter<Contact, ContactResponse> {

    @Override
    public ContactResponse convert(Contact contact) {
        return new ContactResponse(contact);
    }
}
