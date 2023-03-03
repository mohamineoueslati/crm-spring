package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Contact;

public class ContactResponse extends ContactDto {
    private ContactResponse contactOwner;

    public ContactResponse() {
    }

    public ContactResponse(Contact contact) {
        super(contact);
        this.contactOwner = contact.getContactOwner() != null ? new ContactResponse(contact.getContactOwner()) : null;
    }

    public ContactResponse getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(ContactResponse contactOwner) {
        this.contactOwner = contactOwner;
    }

    @Override
    public String toString() {
        return super.toString() + "ContactResponse{" +
                "contactOwner=" + contactOwner +
                '}';
    }
}
