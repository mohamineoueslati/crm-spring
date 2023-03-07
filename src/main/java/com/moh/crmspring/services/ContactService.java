package com.moh.crmspring.services;

import com.moh.crmspring.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> findAllByIds(Iterable<Long> ids);

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
    boolean existsByEmail(String email);
}
