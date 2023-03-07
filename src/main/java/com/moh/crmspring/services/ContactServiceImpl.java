package com.moh.crmspring.services;

import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.exceptions.DuplicatedEntityException;
import com.moh.crmspring.exceptions.NotFoundException;
import com.moh.crmspring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllByIds(Iterable<Long> ids) {
        return contactRepository.findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact with id " + id + " not found"));
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            if (existsByEmail(contact.getEmail()))
                throw new DuplicatedEntityException("Contact with email " + contact.getEmail() + " already exists.");
        } else {
            String email = contactRepository.selectContactEmail(contact.getId());
            boolean sameEmail = email.equals(contact.getEmail());
            if (!sameEmail && existsByEmail(contact.getEmail())) {
                throw new DuplicatedEntityException("Contact with email " + contact.getEmail() + " already exists.");
            }
        }

        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.setContactOwnerToNull(contact.getId());
        contactRepository.delete(contact);
    }

    @Override
    public boolean existsByEmail(String email) {
        return contactRepository.existsByEmail(email);
    }
}
