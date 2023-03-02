package com.moh.crmspring.repositories;

import com.moh.crmspring.entities.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @EntityGraph(value = "Contact.address")
    List<Contact> findAll();
    @EntityGraph(value = "Contact.address")
    List<Contact> findAllById(Iterable<Long> ids);
    @EntityGraph(value = "Contact.address")
    Optional<Contact> findById(Long id);
}
