package com.moh.crmspring.services;

import com.moh.crmspring.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
